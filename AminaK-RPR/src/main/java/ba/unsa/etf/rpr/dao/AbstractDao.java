package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.*;
import java.util.*;

/**
 * Methods that are needed in every extended class are implemented here

 */
public abstract class AbstractDao<T extends Idable> implements Dao<T> {
    /**
     * Attributes for connection
     * singelton pattern
     */

    private Connection connection = null;
    private String tableName;

    /**
     *
     * @param tableName
     * Method for connection to database
     */
    public AbstractDao(String tableName) {
        this.tableName = tableName;
        if (connection == null)

        try{

            Properties p = new Properties();
            p.load(ClassLoader.getSystemResource("application.properties").openStream());
            String url = p.getProperty("db.url");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");
            this.connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            System.out.println("Connection to database not possible!");
            e.printStackTrace();

        }
    }

    /**
     *Constructor for connection
     * @return
     */
    public Connection getConnection(){

        return this.connection;


    }

    /**
     *Method for turning data from database to objects
     * @param rs
     * @return
     * @throws HotelException
     * @throws SQLException
     */

    public abstract T row2object(ResultSet rs) throws HotelException, SQLException;

    /**
     *Method for turning objects into data for database
     * @param object
     * @return
     */
    public abstract Map<String, Object> object2row(T object);

    /**
     *Method for getting data by ID
     * @param id primary key of entity
     * @return
     * @throws HotelException
     */
    public T getById(int id) throws HotelException {
        String query = "SELECT * FROM "+this.tableName+" WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                T result = row2object(rs);
                rs.close();
                return result;
            } else {
                throw new HotelException("Object not found");
            }
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     *Method for getting data by comment
     * @param comment
     * @return
     * @throws HotelException
     */
    public T getByComment(String comment) throws HotelException {
        String query = "SELECT * FROM "+this.tableName+" WHERE comments = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, comment);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                T result = row2object(rs);
                rs.close();
                return result;
            } else {
                throw new HotelException("Object not found");
            }
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     *Method for getting all data from certain table
     * @return
     * @throws HotelException
     */

    public List<T> getAll() throws HotelException {
        String query = "SELECT * FROM "+ tableName;
        List<T> results = new ArrayList<T>();
        try{
            PreparedStatement stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                T object = row2object(rs);
                results.add(object);
            }
            rs.close();
            return results;
        }catch (SQLException e){
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     *Method for deleting data by ID
     * @param id - primary key of entity
     * @throws HotelException
     */
    public void delete(int id) throws HotelException {
        String sql = "DELETE FROM "+tableName+" WHERE id = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     *Method for adding data into database
     * @param item bean for saving to database
     * @return
     * @throws HotelException
     */
    public T add(T item) throws HotelException{
        Map<String, Object> row = object2row(item);
        Map.Entry<String, String> columns = prepareInsertParts(row);

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(tableName);
        builder.append(" (").append(columns.getKey()).append(") ");
        builder.append("VALUES (").append(columns.getValue()).append(")");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);
            // bind params. IMPORTANT treeMap is used to keep columns sorted so params are bind correctly
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setId(rs.getInt(1)); //set id to return it back */

            return item;
        }catch (SQLException e){
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     *Method for updating data
     * @param item - bean to be updated. id must be populated
     * @return
     * @throws HotelException
     */
    public T update(T item) throws HotelException{
        Map<String, Object> row = object2row(item);
        String updateColumns = prepareUpdateParts(row);
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE ")
                .append(tableName)
                .append(" SET ")
                .append(updateColumns)
                .append(" WHERE id = ?");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString());
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.setObject(counter+1, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     * Accepts KV storage of column names and return CSV of columns and question marks for insert statement
     * Example: (id, name, date) ?,?,?
     */
    private Map.Entry<String, String> prepareInsertParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip insertion of id due autoincrement
            columns.append(entry.getKey());
            questions.append("?");
            if (row.size() != counter) {
                columns.append(",");
                questions.append(",");
            }
        }
        return new AbstractMap.SimpleEntry<String,String>(columns.toString(), questions.toString());
    }

    /**
     * Prepare columns for update statement id=?, name=?, ...
     * @param row
     * @return
     */
    private String prepareUpdateParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip update of id due where clause
            columns.append(entry.getKey()).append("= ?");
            if (row.size() != counter) {
                columns.append(",");
            }
        }
        return columns.toString();
    }



}

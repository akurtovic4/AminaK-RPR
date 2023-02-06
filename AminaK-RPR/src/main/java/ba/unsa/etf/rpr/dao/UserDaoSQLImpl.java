package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * implements every method from Dao<T> plus methods from UserDao, extends AbstractDao
 */
public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao {


    public UserDaoSQLImpl() {
        super("users");
    }

    /**
     *
     * @param rs
     * @return
     * @throws HotelException
     * @throws SQLException
     *
     * Method for turning data form database to objects
     */
    @Override
    public User row2object(ResultSet rs) throws HotelException, SQLException {
        User user = new User();
        try{
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setBirth_date(rs.getDate("birth_date").toLocalDate());
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        catch (SQLException e){
            throw new HotelException(e.getMessage());
        }
    }


    /**
     *
     * @param email
     * @return
     * @throws HotelException
     *
     * Method returns user with specific email
     */
    public User getByEmail(String email) throws HotelException{

        String query = "SELECT * FROM  users  WHERE email = ?";

        try{

            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                 User result = row2object(rs);
                rs.close();
                return result;
            } else {
                throw new HotelException("User not found");
            }
        } catch (SQLException e) {
            throw new HotelException(e.getMessage(), e);
        }

    }

    /**
     *
     * @param object
     * @return
     *
     * Method for turning objects to data for database
     */
    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("name", object.getName());
        item.put("birth_date", object.getBirth_date());
        item.put("email", object.getEmail());
        item.put("password", object.getPassword());
        return item;
    }


}

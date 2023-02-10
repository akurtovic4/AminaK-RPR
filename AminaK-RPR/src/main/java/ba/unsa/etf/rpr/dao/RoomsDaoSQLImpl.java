package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * implements every method from Dao<T> plus methods from RoomsDao, extends AbstractDao
 */
public class RoomsDaoSQLImpl extends AbstractDao<Room> implements RoomsDao{
    public RoomsDaoSQLImpl() {
        super("rooms");
    }


    /**
     * Method that turns data from database to objects
     * @param rs
     * @return
     * @throws HotelException
     *
     */


    @Override
    public Room row2object(ResultSet rs) throws HotelException {
        Room room = new Room();
        try{
            room.setId(rs.getInt("id"));
            room.setType( RoomType.valueOf(rs.getString("type")));
            room.setFloor(rs.getInt("floor"));
            room.setPrice(rs.getFloat("price"));
            return room;
        }
        catch (SQLException e){
            throw new HotelException(e.getMessage());
        }
    }

    /**
     *  Method that turns objects to data for database
     * @param object
     * @return
     *
     */
    @Override
    public Map<String, Object> object2row(Room object) {

        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("type", object.getType().toString());
        item.put("floor", object.getFloor());
        item.put("price", object.getPrice());
        return item;
    }

    /**
     * Method that takes all room with specific room type passed as parameter and puts them in a List
     * @param roomType
     * @return
     * @throws HotelException
     *
     *
     */

    public List<Room> allRoomsThatCanWork(String roomType) throws HotelException {

        List<Room> roomsThatCanWork = new ArrayList<>();
        String query = "SELECT * FROM rooms WHERE type = ?";

        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            //parametar index ?, vrijednost
            stmt.setString(1, roomType);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Room result = row2object(rs);
                roomsThatCanWork.add(result);

            }
            rs.close();
        } catch (Exception e) {
            throw new HotelException(e.getMessage(), e);
        }

        return roomsThatCanWork;
    }



}

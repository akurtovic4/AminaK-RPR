package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class RoomsDaoSQLImpl extends AbstractDao<Room> implements RoomsDao{
    public RoomsDaoSQLImpl() {
        super("rooms");
    }

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

    @Override
    public Map<String, Object> object2row(Room object) {

        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("type", object.getType().toString());
        item.put("floor", object.getFloor());
        item.put("price", object.getPrice());
        return item;
    }
}

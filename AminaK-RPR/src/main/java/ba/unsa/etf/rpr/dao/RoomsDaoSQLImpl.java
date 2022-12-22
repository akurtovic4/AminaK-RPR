package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.domain.Rooms;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.util.Map;

public class RoomsDaoSQLImpl extends AbstractDao<Rooms> implements RoomsDao{
    public RoomsDaoSQLImpl(String tableName) {
        super(tableName);
    }

    @Override
    public Rooms row2object(ResultSet rs) throws HotelException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Rooms object) {
        return null;
    }
}

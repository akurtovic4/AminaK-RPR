package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.util.Map;

public class ReservationsDaoSQLImpl extends AbstractDao<Reservations> implements ReservationsDao{
    public ReservationsDaoSQLImpl(String tableName) {
        super(tableName);
    }

    @Override
    public Reservations row2object(ResultSet rs) throws HotelException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Reservations object) {
        return null;
    }
}

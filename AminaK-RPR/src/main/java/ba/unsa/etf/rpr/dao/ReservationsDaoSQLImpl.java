package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class ReservationsDaoSQLImpl extends AbstractDao<Reservation> implements ReservationsDao{
    public ReservationsDaoSQLImpl() {
        super("reservations");
    }

    @Override
    public Reservation row2object(ResultSet rs) throws HotelException {
        try {
            Reservation q = new Reservation();
            q.setId(rs.getInt("id"));
            q.setUser(DaoFactory.usersDao().getById(rs.getInt("user_id")));
            q.setRoom(DaoFactory.roomsDao().getById(rs.getInt("room_id")));
            q.setStart(LocalDate.ofEpochDay(rs.getDate("start").getTime()));
            q.setEnd(LocalDate.ofEpochDay(rs.getDate("end").getTime()));
            q.setComments(rs.getString("comments"));
            return q;
        } catch (Exception e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Reservation object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("start", object.getStart());
        item.put("end", object.getEnd());
        item.put("user_id", object.getUser().getId());
        item.put("room_id", object.getRoom().getId());
        item.put("comments", object.getComments());
        return item;
    }
}

package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * implements every method from Dao<T> plus methods from ReservationDao, extends AbstractDao
 */
public class ReservationsDaoSQLImpl extends AbstractDao<Reservation> implements ReservationsDao{
    /**
     *Constructor for table (from parent class)
     */
    public ReservationsDaoSQLImpl() {
        super("reservations");
    }

    /**
     * Method that turns data from database to objects
     * @param rs
     * @return
     * @throws HotelException
     *
     */

    @Override
    public Reservation row2object(ResultSet rs) throws HotelException {
        try {
            Reservation q = new Reservation();
            q.setId(rs.getInt("id"));
            q.setUser(DaoFactory.usersDao().getById(rs.getInt("user_id")));
            q.setRoom(DaoFactory.roomsDao().getById(rs.getInt("room_id")));
            /* q.setStart(LocalDate.ofEpochDay(rs.getDate("start").getTime()));
            q.setEnd(LocalDate.ofEpochDay(rs.getDate("end").getTime())); */
            q.setStart(rs.getDate("start").toLocalDate());
            q.setEnd(rs.getDate("end").toLocalDate());

            q.setComments(rs.getString("comments"));
            return q;
        } catch (Exception e) {
            throw new HotelException(e.getMessage(), e);
        }
    }

    /**
     *Method that turns objects to data for database
     * @param object
     * @return
     *
     */
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

    /**
     *Method that takes all rooms form database according to start and end date
     * @param startDate
     * @param endDate
     * @return
     * @throws HotelException
     *
     *
     */
    public List<Room> reservedRooms(LocalDate startDate, LocalDate endDate) throws HotelException {

        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM reservations WHERE start >= ? AND end <= ?";

        try {

            PreparedStatement stmt = getConnection().prepareStatement(query);
            //parametar index ?, vrijednost
            stmt.setDate(1, Date.valueOf(startDate));
            stmt.setDate(2, Date.valueOf(endDate));

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reservation result = row2object(rs);
                rooms.add(result.getRoom());

            }
            rs.close();
        } catch (Exception e) {
            throw new HotelException(e.getMessage(), e);
        }

        return rooms;
    }

    /**
     * Method that takes all reservations for one user
     * @param userId
     * @return
     * @throws HotelException
     *
     */

    public  List<Reservation> reservationsForUser(int userId) throws HotelException {
        List<Reservation> reservationsForUser = new ArrayList<>();
        String query = "SELECT * FROM reservations WHERE user_id = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1,userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Reservation result = row2object(rs);
                reservationsForUser.add(result);
            }

        }
        catch (Exception e) {
            throw new HotelException(e.getMessage(), e);
        }

        return reservationsForUser;

    }




}

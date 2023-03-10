package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.time.LocalDate;
import java.util.List;

/**
 * interface that extends Dao<T> plus has methods that are needed only for ReservationDao
 */
public interface ReservationsDao extends Dao<Reservation> {

    /**
     *Method for finding all reserved rooms
     * @param startDate
     * @param endDate
     * @return
     * @throws HotelException
     */
    public List<Room> reservedRooms(LocalDate startDate, LocalDate endDate) throws HotelException;

    /**
     *Method for finding all reservations for specific user
     * @param userId
     * @return
     * @throws HotelException
     */
    public  List<Reservation> reservationsForUser(int userId) throws HotelException;
}

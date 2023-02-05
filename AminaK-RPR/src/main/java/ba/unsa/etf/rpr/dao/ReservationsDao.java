package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.time.LocalDate;
import java.util.List;

public interface ReservationsDao extends Dao<Reservation> {

    public List<Room> reservedRooms(LocalDate startDate, LocalDate endDate) throws HotelException;
}

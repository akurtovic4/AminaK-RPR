package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationManagerTest {

    @Test
    void isTimeValid() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(5);
       assertTrue(startDate.isBefore(endDate));
    }

    @Test
    void add() throws HotelException {
        Reservation reservation = new Reservation();
        User user = new User("Amina", "Kurtovic", LocalDate.now(), 5, "aminko123&");
        Room room = new Room(1, 2.5F,1, RoomType.SINGLE_ROOM);
        reservation.setId(1);
        reservation.setStart(LocalDate.now());
        reservation.setEnd(LocalDate.now().plusDays(5));
        reservation.setUser(user);
        reservation.setComments("tralala");
        reservation.setRoom(room);
        DaoFactory.reservationsDao().add(reservation);

      //  assertEquals(DaoFactory.reservationsDao().getByComment(reservation.getComments()), reservation.getComments());
        assertEquals(DaoFactory.reservationsDao().getByComment("tralala").getComments(), "tralala");

    }
}
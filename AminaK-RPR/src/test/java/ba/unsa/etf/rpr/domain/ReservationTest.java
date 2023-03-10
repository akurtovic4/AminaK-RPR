package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for domain class Reservation
 */
class ReservationTest {

    /**
     * attributes
     */
    Reservation reservation = new Reservation();
    User user = new User("Amina123", "Kurtovic", LocalDate.now(), 5, "aminko123&");
    Room room = new Room(1, 2.5F,1, RoomType.SINGLE_ROOM);


    /**
     * Getter for attribute start test
     */
    @Test
    void getStart() {
        reservation.setId(1);
        reservation.setStart(LocalDate.now());
        reservation.setEnd(LocalDate.now().plusDays(5));
        reservation.setUser(user);
        reservation.setComments("rpr");
        reservation.setRoom(room);
        assertEquals(LocalDate.now(), reservation.getStart());
    }

    /**
     * Getter for attribute end test
     */

    @Test
    void getEnd() {
        reservation.setId(1);
        reservation.setStart(LocalDate.now());
        reservation.setEnd(LocalDate.now().plusDays(5));
        reservation.setUser(user);
        reservation.setComments("rpr");
        reservation.setRoom(room);
        assertEquals(LocalDate.now().plusDays(5), reservation.getEnd());
    }


}
package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.ReservationsDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import org.junit.jupiter.api.Test;

import ba.unsa.etf.rpr.dao.DaoFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import javax.xml.stream.events.Comment;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationManagerTest {

    private ReservationManager reservationManager;
    private Reservation reservation;
    private  String comment = "tralala";
    private ReservationsDaoSQLImpl reservationsDaoSQLMock;
    private List<Reservation> reservations;

    @BeforeEach
    public void initializeObjectsWeNeed() {
        reservationManager = Mockito.mock(ReservationManager.class);
        reservation = new Reservation();
       reservation.setComments(comment);
        reservation.setId(50);

        reservationsDaoSQLMock = Mockito.mock(ReservationsDaoSQLImpl.class);
        reservations = new ArrayList<>();
       // reservations.addAll(Arrays.asList(new Reservation(1,));
    }
    @Test
    void isTimeValid() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(5);
       assertTrue(startDate.isBefore(endDate));
    }

    @Test
    void add() throws HotelException {
//mokanje dao factory klase
       // MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
       // daoFactoryMockedStatic.when(DaoFactory::reservationsDao).thenReturn(reservationsDaoSQLMock);
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
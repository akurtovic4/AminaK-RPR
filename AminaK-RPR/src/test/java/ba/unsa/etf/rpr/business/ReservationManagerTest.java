package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.*;
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
import org.mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import javax.xml.stream.events.Comment;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



class ReservationManagerTest {

    private List<Reservation> res = new ArrayList<>();

    private ReservationsDaoSQLImpl reservationsDaoSQLMock = Mockito.mock(ReservationsDaoSQLImpl.class);
    private RoomsDaoSQLImpl roomsDaoSQLMock = Mockito.mock(RoomsDaoSQLImpl.class);
    private ReservationManager reservationManager = new ReservationManager();




    @Test
    void isTimeValid() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(5);
       assertTrue(startDate.isBefore(endDate));
    }





    @Test
        void add() throws HotelException{
        Reservation reservation = new Reservation();
        User user = new User("Amina123", "Kurtovic", LocalDate.now(), 5, "aminko123&");
        Room room = new Room(1, 2.5F,1, RoomType.SINGLE_ROOM);
        reservation.setId(1);
        reservation.setStart(LocalDate.now());
        reservation.setEnd(LocalDate.now().plusDays(5));
        reservation.setUser(user);
        reservation.setComments("rpr");
        reservation.setRoom(room);

        MockedStatic<DaoFactory> mockedFactory = Mockito.mockStatic(DaoFactory.class);
        mockedFactory.when(DaoFactory::reservationsDao).thenReturn(reservationsDaoSQLMock);
        Reservation expected = new Reservation();
        when(reservationsDaoSQLMock.add(Mockito.any(Reservation.class))).thenReturn(expected);
        Reservation actual = reservationsDaoSQLMock.add(new Reservation());
        assertEquals(expected, actual);
        mockedFactory.close();
    }



}
package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class UserManagerTest {



    private UserDaoSQLImpl usersDaoSQLMock = Mockito.mock(UserDaoSQLImpl.class);

    private UserManager userManager = new UserManager();
    @BeforeEach
    public void setUp() {
        User user = new User();
        user.setId(1);
        user.setBirth_date(LocalDate.now());
        user.setPassword("Amina123&");
        user.setEmail("amina12345");
        user.setName("Aminko");


        usersDaoMock = Mockito.mock(UserDao.class);


    }
    private UserDao usersDaoMock;
    private UserManager userService;
    @Test
    void add() throws HotelException {


        User user = new User("Amina123", "Kurtovic", LocalDate.now(), 5, "aminko123&");


        MockedStatic<DaoFactory> mockedFactory = Mockito.mockStatic(DaoFactory.class);
        mockedFactory.when(DaoFactory::usersDao).thenReturn(usersDaoSQLMock);
        User expected = new User();
        when(usersDaoSQLMock.add(Mockito.any(User.class))).thenReturn(expected);
        User actual = usersDaoSQLMock.add(new User());
        assertEquals(expected, actual);
        mockedFactory.close();
    }



}
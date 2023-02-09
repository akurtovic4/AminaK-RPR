package ba.unsa.etf.rpr.domain;

import ba.unsa.etf.rpr.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user = new User();
    @BeforeEach
    public void setUp() {


        user.setId(1);
        user.setBirth_date(LocalDate.now());
        user.setPassword("Amina123&");
        user.setEmail("amina12345");
        user.setName("Aminko");

    }

    @Test
    void getName() {
        assertEquals("Aminko", user.getName());
    }

    @Test
    void getEmail() {
        assertEquals("amina12345", user.getEmail());
    }

    @Test
    void getBirth_date() {
        assertEquals(LocalDate.now(), user.getBirth_date());
    }

    @Test
    void getPassword() {
        assertEquals("Amina123&", user.getPassword());
    }

}
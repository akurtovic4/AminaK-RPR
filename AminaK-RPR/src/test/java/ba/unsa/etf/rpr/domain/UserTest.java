package ba.unsa.etf.rpr.domain;

import ba.unsa.etf.rpr.dao.UserDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests for domain class User
 */
class UserTest {

    /**
     * new user
     */
    private User user = new User();

    /**
     * setting up new user
     */
    @BeforeEach
    public void setUp() {


        user.setId(1);
        user.setBirth_date(LocalDate.now());
        user.setPassword("Amina123&");
        user.setEmail("amina12345");
        user.setName("Aminko");

    }

    /**
     * Getter test for attribute name
     */
    @Test
    void getName() {
        assertEquals("Aminko", user.getName());
    }

    /**
     * Getter test for attribute email
     */
    @Test
    void getEmail() {
        assertEquals("amina12345", user.getEmail());
    }

    /**
     * Getter test for attribute birth_date
     */
    @Test
    void getBirth_date() {
        assertEquals(LocalDate.now(), user.getBirth_date());
    }

    /**
     * Getter test for attribute password
     */
    @Test
    void getPassword() {
        assertEquals("Amina123&", user.getPassword());
    }

}
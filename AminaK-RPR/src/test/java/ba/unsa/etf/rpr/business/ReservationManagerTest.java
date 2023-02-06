package ba.unsa.etf.rpr.business;

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
    void add() {
    }
}
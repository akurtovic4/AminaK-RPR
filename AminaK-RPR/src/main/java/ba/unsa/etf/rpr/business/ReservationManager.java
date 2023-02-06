package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.time.LocalDate;

/**
 * This class represents business layer for Reservations. Here are methods that check all actions connected with making reservation
 */
public class ReservationManager {

    /**
     *
     * @param startDate
     * @param endDate
     * @throws HotelException
     *
     * Method for checking if time is valid, end date must be after start date
     */
    public void isTimeValid(LocalDate startDate, LocalDate endDate) throws HotelException {
        if(endDate.isBefore(startDate))  throw new HotelException("Start date must be before end date");
    }

    public Reservation add(Reservation item) throws HotelException{
        return DaoFactory.reservationsDao().add(item);
    }


}




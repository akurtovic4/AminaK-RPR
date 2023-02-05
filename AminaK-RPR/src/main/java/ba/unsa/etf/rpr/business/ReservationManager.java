package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.time.LocalDate;

public class ReservationManager {

    public void isTimeValid(LocalDate startDate, LocalDate endDate) throws HotelException {
        if(endDate.isBefore(startDate))  throw new HotelException("Start date must be before end date");
    }

    public Reservation add(Reservation item) throws HotelException{
        return DaoFactory.reservationsDao().add(item);
    }

}




package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.time.LocalDate;

/**
 * Hello world!
 *QUESTIONS:
 * da li domain clase moraju da budu imenovane u mnozini ili jednini
 * da li moramo koristiti singleton pattern i koji ce biti problemi ako ne koristimo
 */
public class App 
{
    public static void main( String[] args ) throws HotelException {

        UserManager um = new UserManager();
        User u =  um.login("akurtovic4@etf.unsa.bak", "1234");
        System.out.println(u.toString());






    }
}

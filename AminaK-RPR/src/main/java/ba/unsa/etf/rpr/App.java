package ba.unsa.etf.rpr;

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

        //insanca usera koriteci dao factory
        User dino = new User();
        dino.setName("Dino");
        dino.setId(2);
        dino.setEmail("dkecotralala");
        dino.setBirth_date(LocalDate.of(1988, 01, 27));
        UserDao dao = new UserDaoSQLImpl();
       // dao.add(dino);

        Room soba = new Room();
        soba.setType(RoomType.PRESIDENTIAL_SUITE);
        soba.setId(2);
        soba.setFloor(10);
        soba.setPrice(300f);
        RoomsDao dao1 = new RoomsDaoSQLImpl();

        Reservation rez = new Reservation();
        rez.setRoom(soba);
        rez.setUser(dino);
        rez.setComments("tralalala");
        rez.setStart(LocalDate.of(2023, 3,15));
        rez.setEnd(LocalDate.of(2023, 3, 20));
        ReservationsDao rdao = new ReservationsDaoSQLImpl();
        rdao.add(rez);
       // dao1.add(soba);






    }
}

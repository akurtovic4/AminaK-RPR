package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.util.Pair;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!

 */
public class App 
{
    public static void main( String[] args ) throws HotelException {


            System.out.println("Hello. Welcome to hotel Aminolino!");
            Scanner scanner = new Scanner(System.in);

            System.out.println("If you like to log in type 1, if you want to register, type 2");
            if(scanner.nextInt() == 1) {
                String name;
                String pass;
                System.out.print("Email: ");
                Scanner scanner1 = new Scanner(System.in);
                name = scanner1.next();
                System.out.print("Password: ");
                pass = scanner.next();
                while(true){
                  User  user = DaoFactory.usersDao().getByEmail(name);

                    if (user != null && user.getPassword().equals(pass)){
                        System.out.println("Login successful\n");
                        break;
                    }
                    System.out.println("Username or password is wrong. Please try again.");
                  /*  tmp = getInputData();
                    userName = tmp.getKey();
                    userPassword = tmp.getValue();*/
                }
            }






    }
}

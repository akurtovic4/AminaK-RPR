package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                    String name1;
                    String pass1;
                    System.out.print("Email: ");
                    Scanner scanner2 = new Scanner(System.in);
                    name = scanner2.next();
                    System.out.print("Password: ");

                    pass = scanner2.next();
                }
            }
            if(scanner.nextInt() == 2){
                try{
                    String name, email, password, cpassword;
                    LocalDate DOB;
                    System.out.print("Name: ");
                    Scanner scanner3 = new Scanner(System.in);
                    name = scanner3.next();
                    System.out.print("Email: ");
                    Scanner scanner4 = new Scanner(System.in);
                    email = scanner4.next();
                    DOB = addDate();
                    System.out.print("Password: ");
                    Scanner scanner5 = new Scanner(System.in);
                    password = scanner5.next();
                    System.out.print("Confirm password: ");
                    Scanner scanner6 = new Scanner(System.in);
                    cpassword = scanner6.next();
                    User user = new User();
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(cpassword);
                    user.setId(1);
                    UserManager.add(user, cpassword);

                }catch (Exception e){
                    e.printStackTrace();
                }





            }






    }

    public static LocalDate addDate() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a date of birth [dd/MM/yyyy]: ");
        String str = scan.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(str, dtf);
    }
}

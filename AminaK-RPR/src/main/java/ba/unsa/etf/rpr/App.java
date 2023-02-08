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
import java.util.List;
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
                User  user = DaoFactory.usersDao().getByEmail(name);
                while(true){


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
                options(user.getId());
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
                    user.setBirth_date(DOB);

                    UserManager.add(user, cpassword);
                    options(user.getId());
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

    private static void options(int userID) throws HotelException {
        System.out.println("How can we help you today ");
        System.out.println("1: Show me a list of my reservations");
        System.out.println("2. Make a reservation");
        System.out.println("3. Log out");



        Scanner scanner = new Scanner(System.in);
        int action1;
        while(true){
            System.out.print("I want: ");
            action1 = scanner.nextInt();
            if (action1 < 1 || action1 > 3){
                System.out.println("You haven't choose any option, please try again");
            }
            else break;
        }
       int action = action1;



       switch (action){
           case 1 : listOfReservtionOfaUser(userID);
          //  case 2-> buyNewTickets(userID);
           case 2 : System.exit(0);
        }
    }


    private static void listOfReservtionOfaUser(int userID) throws HotelException {
        List<Reservation> listOfReservations = DaoFactory.reservationsDao().reservationsForUser(userID);
        if (listOfReservations.isEmpty()){
            System.out.println("You haven't made any reservations yet!\n");
            options(userID);
            return;
        }
        System.out.println("Your current reservations: ");
        for (Reservation x: listOfReservations){
            System.out.println(x.toString());
        }
        options(userID);
    }
}

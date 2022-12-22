package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.AbstractDao;
import ba.unsa.etf.rpr.dao.RoomsDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UsersDao;
import ba.unsa.etf.rpr.dao.UsersDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Rooms;
import ba.unsa.etf.rpr.domain.Users;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AbstractDao<Users> korisnici = new UsersDaoSQLImpl("Users");
        AbstractDao<Rooms> soba = new RoomsDaoSQLImpl("Soba");
        Users korisnik = new Users("Amina", "Kurtovic", "2001-02-16", 1)
    }
}

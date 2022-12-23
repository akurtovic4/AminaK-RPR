package ba.unsa.etf.rpr.dao;

public class DaoFactory {

    private static final ReservationsDao reservationsDao = new ReservationsDaoSQLImpl();
    private static final UsersDao usersDao = new UsersDaoSQLImpl();
    private static final RoomsDao roomsDao = new RoomsDaoSQLImpl();

   private DaoFactory(){
    }

    public static ReservationsDao reservationsDao(){
        return reservationsDao;
    }

    public static UsersDao usersDao(){
        return usersDao;
    }

    public static RoomsDao roomsDao(){
        return roomsDao;
    }

}

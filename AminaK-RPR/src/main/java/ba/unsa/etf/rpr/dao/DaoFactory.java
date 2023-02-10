package ba.unsa.etf.rpr.dao;

/**
 *DaoFactory class for making instances od dao classes
 */
public class DaoFactory {

    /**
     * static method for DaoFactory
     */
    private static final ReservationsDao reservationsDao = new ReservationsDaoSQLImpl();
    private static final UserDao usersDao = new UserDaoSQLImpl();
    private static final RoomsDao roomsDao = new RoomsDaoSQLImpl();

    /**
     *Constructor for DaoFactory
     */
   private DaoFactory(){
    }

    /**
     *Method needed to access ReservationsDao instance
     * @return
     */
    public static ReservationsDao reservationsDao(){
        return reservationsDao;
    }

    /**
     *Method needed to access UserDao instance
     * @return
     */
    public static UserDao usersDao(){
        return usersDao;
    }

    /**
     *Method needed to access RoomsDao instance
     * @return
     */
    public static RoomsDao roomsDao(){
        return roomsDao;
    }

}

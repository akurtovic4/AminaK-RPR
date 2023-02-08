package ba.unsa.etf.rpr.dao;

/**
 *
 */
public class DaoFactory {

    private static final ReservationsDao reservationsDao = new ReservationsDaoSQLImpl();
    private static final UserDao usersDao = new UserDaoSQLImpl();
    private static final RoomsDao roomsDao = new RoomsDaoSQLImpl();

    /**
     *
     */
   private DaoFactory(){
    }

    /**
     *
     * @return
     */
    public static ReservationsDao reservationsDao(){
        return reservationsDao;
    }

    /**
     *
     * @return
     */
    public static UserDao usersDao(){
        return usersDao;
    }

    /**
     *
     * @return
     */
    public static RoomsDao roomsDao(){
        return roomsDao;
    }

}

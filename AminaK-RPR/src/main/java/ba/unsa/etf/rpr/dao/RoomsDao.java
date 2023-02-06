package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.util.List;
/**
 * interface that extends Dao<T> plus has methods that are needed only for RoomsDao
 */
public interface RoomsDao extends Dao<Room> {

    public List<Room> allRoomsThatCanWork(String roomType) throws HotelException;
}

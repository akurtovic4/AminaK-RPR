package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.util.List;

public interface RoomsDao extends Dao<Room> {

    public List<Room> allRoomsThatCanWork(String roomType) throws HotelException;
}

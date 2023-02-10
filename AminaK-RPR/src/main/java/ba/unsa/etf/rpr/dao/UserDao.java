package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

/**
 * interface that extends Dao<T> plus has methods that are needed only for UserDao
 */
public interface UserDao extends Dao<User> {
    /**
     *Method that finds user by email
     * @param email
     * @return
     * @throws HotelException
     */
    User getByEmail(String email) throws HotelException;
}

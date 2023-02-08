package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

/**
 * interface that extends Dao<T> plus has methods that are needed only for Userdao
 */
public interface UserDao extends Dao<User> {
    /**
     *
     * @param email
     * @return
     * @throws HotelException
     */
    User getByEmail(String email) throws HotelException;
}

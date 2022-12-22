package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.domain.Users;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.util.Map;

public class UsersDaoSQLImpl extends AbstractDao<Users> implements UsersDao{
    public UsersDaoSQLImpl(String tableName) {
        super(tableName);
    }

    @Override
    public Users row2object(ResultSet rs) throws HotelException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Users object) {
        return null;
    }
}

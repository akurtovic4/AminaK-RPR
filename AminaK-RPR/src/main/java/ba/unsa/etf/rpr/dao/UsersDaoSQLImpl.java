package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class UsersDaoSQLImpl extends AbstractDao<User> implements UsersDao{
    public UsersDaoSQLImpl() {
        super("users");
    }

    @Override
    public User row2object(ResultSet rs) throws HotelException, SQLException {
        User user = new User();
        try{
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setBirth_date(LocalDate.ofEpochDay(rs.getDate("birth_date").getTime()));
            user.setEmail(rs.getString("email"));
            return user;
        }
        catch (SQLException e){
            throw new HotelException(e.getMessage());
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("name", object.getName());
        item.put("birth_date", object.getBirth_date());
        item.put("email", object.getEmail());
        return item;
    }
}

package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.util.List;

public class RegisterManager {

    public void validateUsername(String name) throws HotelException{
        if (name == null || name.length() > 25|| name.length() < 5){
            throw new HotelException("Username must have between 5 and 25 letters");
        }
    }



}

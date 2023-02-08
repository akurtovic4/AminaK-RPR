package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.UserDao;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.time.LocalDate;
import java.time.Period;

/**
 *This class represents business layer for Users. Here are methods that check all actions connected with login and registration
 */
public class UserManager {


    /**
     *
     * @param user
     * @param confirmPasswordText
     * @return
     * @throws HotelException
     * This method adds user only if his username and password are correct
     */

    public User add(User user, String confirmPasswordText) throws HotelException {

        if (user.getName().equals(null) || user.getPassword().equals(null) || user.getEmail().equals(null) || user.getBirth_date()==null || confirmPasswordText.equals(null)){
            throw new HotelException("All fields have to be filled");
        }
        if (user.getId() != 0){
            throw new HotelException("ID is autogenerated");
        }

        Period intervalPeriod = Period.between(user.getBirth_date(), LocalDate.now());
        if (intervalPeriod.getYears() < 18){
            throw new HotelException("User has to be adult");
        }

         if(user.getPassword().length() < 8 || !user.getPassword().contains("&") || !user.getPassword().contains("%")){

            throw new HotelException("Password has do be 8 characters long and contain & or %");

        }

        if(!user.getPassword().equals(confirmPasswordText)){
            throw new HotelException("Passwords have to match");
        }

        try{
            return DaoFactory.usersDao().add(user);
        }catch (HotelException e){
            if (e.getMessage().contains("email")){
                throw new HotelException("User with same email exists");
            }
            System.out.println("desilose");
            throw e;
        }




    }

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws HotelException
     * This method logs user in only if all fields are filled and username and password are correct
     */

    public User login(String email, String password) throws HotelException {

        if(email == null || password.equals("")){
            throw new HotelException("All fields have to be filled");
        }
        User u = DaoFactory.usersDao().getByEmail(email);

        if(!u.getPassword().equals(password)){
            throw new HotelException("Password incorrect");
        }
        return u;

    }

}

package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Domain Javabean class User with all attributes needed for room information such as id, name, email, birthdate and password
 * Also, setters and getters for each attribute
 */
public class User implements Idable, Serializable {

    /**
     * Class attributes
     */
    private int id;
    private String name;
    private String email;
    private LocalDate birth_date;
    private String password;

    /**
     * Class constructor with all parameters
     * @param name
     * @param email
     * @param birth_date
     * @param id
     * @param password
     */
    public User(String name, String email, LocalDate birth_date, int id, String password) {
        this.name = name;
        this.email = email;
        this.birth_date = birth_date;
        this.id = id;
        this.password = password;
    }

 /**
 Class constructor with zero parameters
  */
    public User() {
    }

    /**
     * Getter for attribute name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for attribute name
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for attribute email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for attribute email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void setId(int id) {
    this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer: " + this.name+
                "Email: " + this.email+
                "Birthdate: "+ this.birth_date+
                "ID: " + this.id+
                "password" + this.password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(birth_date, user.birth_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birth_date);
    }
}





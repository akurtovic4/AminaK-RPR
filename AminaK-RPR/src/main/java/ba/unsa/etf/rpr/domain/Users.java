package ba.unsa.etf.rpr.domain;

import java.time.LocalDate;
import java.util.Date;

public class Users implements Idable{

    private String name;
    private String email;
    private LocalDate birth_date;
    private int id;

    public Users(String name, String email, Date birth_date, int id) {
        this.name = name;
        this.email = email;
        this.birth_date = birth_date;
        this.id = id;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Customer: " + this.name+
                "Email: " + this.email+
                "Birthdate: "+ this.birth_date+
                "ID: " + this.id;
    }
}




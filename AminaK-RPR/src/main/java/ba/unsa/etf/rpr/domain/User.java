package ba.unsa.etf.rpr.domain;

import java.time.LocalDate;
import java.util.Objects;

public class User implements Idable{

    private int id;
    private String name;
    private String email;
    private LocalDate birth_date;


    public User(String name, String email, LocalDate birth_date, int id) {
        this.name = name;
        this.email = email;
        this.birth_date = birth_date;
        this.id = id;
    }

    public User(String amina, LocalDate localDate, String email) {
    }


    public User() {
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

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
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
                "ID: " + this.id;
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




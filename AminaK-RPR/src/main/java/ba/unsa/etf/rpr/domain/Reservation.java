package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Domain Javabean class Reservation with all attributes needed for reservation such as id, startDate, endDate, user who made reservation, and room that is reserved.
 * Also, setters and getters for each attribute
 */
public class Reservation implements Idable, Serializable {

    /**
     * Attributes for class Reservation
     */
    private int id;
    private LocalDate start;
    private LocalDate end;
    private String comments;

    private User user;
    private Room room;



    /**
     Class constructor with zero parameters
     */
    public Reservation() {
    }

    /**
     * Class constructor with all parameters
     * @param id
     * @param start
     * @param end
     * @param comments
     * @param user
     * @param room
     */
    public Reservation(int id, LocalDate start, LocalDate end, String comments, User user, Room room) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.comments = comments;
        this.user = user;
        this.room = room;
    }

    /**
     * Getter for reservation id
     * @return
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Setter for reservation id
     * @return
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Getter for reservation start date
     * @return
     */
    public LocalDate getStart() {
        return start;
    }
    /**
     * Setter for reservation start date
     * @return
     */
    public void setStart(LocalDate start) {
        this.start = start;
    }

    /**
     * Getter for reservation start date
     * @return
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * Setter for reservation end date
     * @return
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     * Getter for comments about reservation
     * @return
     */
    public String getComments() {
        return comments;
    }

    /**
     * Setter for comments about reservation
     * @return
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Getter for attribute user
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for attribute user
     * @return
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter for attribute room
     * @return
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Setter for attribute room
     * @return
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Method for comparing reservations by all attributes
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id && Objects.equals(start, that.start) && Objects.equals(end, that.end) && Objects.equals(comments, that.comments) && Objects.equals(user, that.user) && Objects.equals(room, that.room);
    }

    /**
     * hashCode method for hashing users attributes
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, comments, user, room);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", comments='" + comments + '\'' +
                ", user=" + user +
                ", room=" + room +
                '}';
    }
}
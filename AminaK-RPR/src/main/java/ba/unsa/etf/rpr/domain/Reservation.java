package ba.unsa.etf.rpr.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Reservation implements Idable{

    private int id;
    private LocalDate start;
    private LocalDate end;
    private String comments;

    private User user;
    private Room room;


    public Reservation() {
    }

    public Reservation(int id, LocalDate start, LocalDate end, String comments, User user, Room room) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.comments = comments;
        this.user = user;
        this.room = room;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id && Objects.equals(start, that.start) && Objects.equals(end, that.end) && Objects.equals(comments, that.comments) && Objects.equals(user, that.user) && Objects.equals(room, that.room);
    }

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
package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Reservations implements Idable{

    private int id;
    private Date start;
    private Date end;
    private String comments;

    public Reservations(int id, Date start, Date end, String comments) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.comments = comments;
    }

    public Reservations() {
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }
}

package ba.unsa.etf.rpr.domain;

public class Rooms implements Idable{

    private int id;
    private boolean availability;

    public Rooms(int id, boolean availability) {
        this.id = id;
        this.availability = availability;
    }

    public Rooms() {
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }
}

package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Room implements Idable{

    private int id;
    private Float price;
    private Integer floor;
    private RoomType type;


    public Room() {
    }

    public Room(int id, Float price, Integer floor, RoomType type) {
        this.id = id;
        this.price = price;
        this.floor = floor;
        this.type = type;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", floor=" + floor +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && Objects.equals(price, room.price) && Objects.equals(floor, room.floor) && type == room.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor);
    }
}
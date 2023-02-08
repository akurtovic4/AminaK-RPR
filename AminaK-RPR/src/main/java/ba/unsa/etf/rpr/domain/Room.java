package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Domain Javabean class Room with all attributes needed for room information such as id, price, floor and room type
 * Also, setters and getters for each attribute
 */
public class Room implements Idable, Serializable {

    /**
     * Attributes for java class Room
     */
    private int id;
    private Float price;
    private Integer floor;
    private RoomType type;

    /**
     Class constructor with zero parameters
     */
    public Room() {
    }

    /**
     *  Class constructor with all parameters
     * @param id
     * @param price
     * @param floor
     * @param type
     */
    public Room(int id, Float price, Integer floor, RoomType type) {
        this.id = id;
        this.price = price;
        this.floor = floor;
        this.type = type;
    }

    /**
     * Getter for attribute id
     * @return
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Setter for attribute id
     * @return
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for attribute price
     * @return
     */
    public Float getPrice() {
        return price;
    }
    /**
     * Setter for attribute price
     * @return
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Getter for attribute floor
     * @return
     */
    public Integer getFloor() {
        return floor;
    }
    /**
     * Setter for attribute floor
     * @return
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     * Getter for attribute type
     * @return
     */
    public RoomType getType() {
        return type;
    }
    /**
     * Setter for attribute type
     * @return
     */
    public void setType(RoomType type) {
        this.type = type;
    }

    /**
     * Method for printing values for attributes of a room
     * @return
     */
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
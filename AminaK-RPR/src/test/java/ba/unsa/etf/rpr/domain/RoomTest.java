package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for domain class Room
 */
class RoomTest {
    /**
     * making new room and setting it
     */
    private Room room = new Room(1, 2.5F, 3, RoomType.SINGLE_ROOM);

    /**
     * Getter for attribute price test
     */
    @Test
    void getPrice() {
    assertEquals(2.5F, room.getPrice());
    }

    /**
     * Getter for attribute floor test
     */
    @Test
    void getFloor() {
        assertEquals(3, room.getFloor());
    }



    @Test
    void testToString() {


        String expected = "Room" +
                "{id=" + room.getId() +
                ", price=" + room.getPrice() +
                ", floor=" + room.getFloor() +
                ", type=" + room.getType() + "}";
        assertEquals(expected, room.toString());

    }
}
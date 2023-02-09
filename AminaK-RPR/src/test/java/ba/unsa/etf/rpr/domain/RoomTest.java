package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RoomTest {

    private Room room = new Room(1, 2.5F, 3, RoomType.SINGLE_ROOM);
    @Test
    void getPrice() {
    assertEquals(2.5F, room.getPrice());
    }


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
                ", type=" + room.getType() + "}"; // put the expected value here
        assertEquals(expected, room.toString());

    }
}
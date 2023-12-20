package com.ldts.steven.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    public void testGetPosition(){
        Position position = new Position(10,10);

        Position left = position.getLeft();
        Position right = position.getRight();
        Position up = position.getUp();
        Position down = position.getDown();

        Assertions.assertEquals(left.getX(), position.getX()-1);
        Assertions.assertEquals(right.getX(), position.getX()+1);
        Assertions.assertEquals(up.getY(), position.getY()-1);
        Assertions.assertEquals(down.getY(), position.getY()+1);

    }
    @Test
    public void testEquals() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        assertEquals(position1, position2);

        Position position3 = new Position(3, 2);
        assertNotEquals(position1, position3);

        Position position4 = new Position(1, 4);
        assertNotEquals(position1, position4);

        Position position5 = new Position(3, 4);
        assertNotEquals(position1, position5);

        assertNotEquals(null, position1);
        assertEquals(position1, position1);
        assertEquals(position1, new Position(1, 2));
    }
}

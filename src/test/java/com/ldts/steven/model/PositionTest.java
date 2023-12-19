package com.ldts.steven.model;

import com.ldts.steven.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}

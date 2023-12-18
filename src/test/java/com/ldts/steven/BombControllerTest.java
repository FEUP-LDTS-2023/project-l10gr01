package com.ldts.steven;


import com.ldts.steven.controller.game.BombController;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Random;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BombControllerTest {

    private BombController bombConMock;
    private Steven stevenMock;
    private Arena arenaMock;
    private Game gameMock;

    @BeforeEach
    void setUp() {
        arenaMock = mock(Arena.class);
        gameMock = mock(Game.class);
        stevenMock = mock(Steven.class);
        bombConMock = new BombController(arenaMock);
        when(arenaMock.getSteven()).thenReturn(stevenMock);
    }

    @Test
    void testPlantNormalBomb() {
        Position position = new Position(1, 1);
        when(stevenMock.getBombUp()).thenReturn(false);
        bombConMock.plantBomb(position);

        verify(arenaMock).addBomb(Mockito.any(NormalBomb.class));
    }
    @Test
    void testPlantUpgradedBomb(){
        Position position = new Position(1, 1);
        when(bombConMock.getModel().getSteven().getBombUp()).thenReturn(true);
        bombConMock.plantBomb(position);

        verify(arenaMock).addBomb(Mockito.any(UpgradedBomb.class));
    }
    @Test
    void testBombHurtSteven() {

        Bomb bombMock = mock(Bomb.class);
        when(bombMock.hasExploded()).thenReturn(true);
        when(arenaMock.isBomb(stevenMock.getPosition())).thenReturn(true);
        when(arenaMock.getBombs()).thenReturn(List.of(bombMock));

        bombConMock.step(gameMock, GUI.ACTION.NONE, 0);

        verify(stevenMock).decreaseLifes();
        Assertions.assertTrue(bombConMock.getHurtSteven());

    }
    @Test
    void testBreakWalls() {
        Bomb bombMock = mock(Bomb.class);
        when(bombMock.hasExploded()).thenReturn(true);
        when(arenaMock.getBombs()).thenReturn(List.of(bombMock));
        BreakableWall wall1 = mock(BreakableWall.class);
        BreakableWall wall2 = mock(BreakableWall.class);
        when(arenaMock.getBreakableWalls()).thenReturn(List.of(wall1, wall2));
        when(bombConMock.getModel().isBomb(wall1.getPosition())).thenReturn(true);
        when(bombConMock.getModel().isBomb(wall2.getPosition())).thenReturn(true);
        bombConMock.step(gameMock, GUI.ACTION.NONE, 0);

        verify(arenaMock).breakWall(wall1);
        verify(arenaMock).breakWall(wall2);

    }
}

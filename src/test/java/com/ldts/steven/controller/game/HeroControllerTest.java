package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Steven;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HeroControllerTest {

    private HeroController heroController;
    private Game gameMock;
    private BombController bombConMock;

    @BeforeEach
    void setUp() {
        Arena arenaMock = mock(Arena.class);
        bombConMock = mock(BombController.class);
        heroController = new HeroController(arenaMock, bombConMock);
        gameMock = mock(Game.class);
    }

    @Test
    void testMoveHeroLeft() {
        Position initialPosition = new Position(1, 1);
        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroController.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.step(gameMock, GUI.ACTION.LEFT, 0);

        Position expectedPosition = new Position(0, 1);
        verify(stevenMock).setPosition(expectedPosition);
    }
    @Test
    void testMoveHeroRight() {
        Position initialPosition = new Position(1, 1);
        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroController.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.step(gameMock, GUI.ACTION.RIGHT, 0);

        Position expectedPosition = new Position(2, 1);
        verify(stevenMock).setPosition(expectedPosition);
    }
    @Test
    void testMoveHeroUp() {
        Position initialPosition = new Position(1, 1);
        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroController.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.step(gameMock, GUI.ACTION.UP, 0);

        Position expectedPosition = new Position(1, 0);
        verify(stevenMock).setPosition(expectedPosition);
    }
    @Test
    void testMoveHeroDown() {
        Position initialPosition = new Position(1, 1);
        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroController.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.step(gameMock, GUI.ACTION.DOWN, 0);

        Position expectedPosition = new Position(1, 2);
        verify(stevenMock).setPosition(expectedPosition);
    }
    @Test
    void testHurtSteven(){
        Steven stevenMock = mock(Steven.class);
        Position initialPosition = new Position(1, 1);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroController.getModel().isMonster(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().isBomb(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.moveHeroDown();

        verify(stevenMock).decreaseLifes();
    }
    @Test
    void testGetLife(){
        Steven stevenMock = mock(Steven.class);
        Position initialPosition = new Position(1, 1);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroController.getModel().isLife(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.moveHeroDown();

        verify(stevenMock).increaseLifes();
    }
    @Test
    void testGetBombUp(){
        Steven stevenMock = mock(Steven.class);
        Position initialPosition = new Position(1, 1);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroController.getModel().isBombUpgrade(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.moveHeroDown();

        verify(stevenMock).setBombUp(true);
    }
    @Test
    void testGetUnlimitedUp() {
        Steven stevenMock = mock(Steven.class);
        Position initialPosition = new Position(1, 1);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroController.getModel().isUnlimitedBomb(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.moveHeroDown();

        verify(heroController.getModel()).setUnlimitedUp(true);
    }
    @Test
    void testHeroPlantBomb(){

        Steven stevenMock = mock(Steven.class);
        when(heroController.getModel().getSteven()).thenReturn(stevenMock);

        heroController.step(gameMock, GUI.ACTION.SPACE, 0);

        verify(bombConMock).plantBomb(stevenMock.getPosition());
    }
}
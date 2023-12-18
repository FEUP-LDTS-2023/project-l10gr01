package com.ldts.steven;

import com.ldts.steven.controller.game.BombController;
import com.ldts.steven.controller.game.HeroController;
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

    private HeroController heroConMock;

    @BeforeEach
    void setUp() {
        Arena arenaMock = mock(Arena.class);
        BombController bombConMock = mock(BombController.class);
        heroConMock = new HeroController(arenaMock, bombConMock);
    }

    @Test
    void testMoveHeroLeft() {
        Position initialPosition = new Position(1, 1);
        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().getSteven()).thenReturn(stevenMock);

        heroConMock.moveHeroLeft();

        Position expectedPosition = new Position(0, 1);
        verify(stevenMock).setPosition(expectedPosition);
    }
    @Test
    void testMoveHeroRight() {
        Position initialPosition = new Position(1, 1);
        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().getSteven()).thenReturn(stevenMock);

        heroConMock.moveHeroRight();

        Position expectedPosition = new Position(2, 1);
        verify(stevenMock).setPosition(expectedPosition);
    }
    @Test
    void testMoveHeroUp() {
        Position initialPosition = new Position(1, 1);
        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().getSteven()).thenReturn(stevenMock);

        heroConMock.moveHeroUp();

        Position expectedPosition = new Position(1, 0);
        verify(stevenMock).setPosition(expectedPosition);
    }
    @Test
    void testMoveHeroDown() {
        Position initialPosition = new Position(1, 1);
        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().getSteven()).thenReturn(stevenMock);

        heroConMock.moveHeroDown();

        Position expectedPosition = new Position(1, 2);
        verify(stevenMock).setPosition(expectedPosition);
    }
    @Test
    void testHurtSteven(){
        Steven stevenMock = mock(Steven.class);
        Position initialPosition = new Position(1, 1);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroConMock.getModel().isMonster(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().isBomb(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().getSteven()).thenReturn(stevenMock);

        heroConMock.moveHeroDown();

        verify(stevenMock).decreaseLifes();
    }
    @Test
    void testGetLife(){
        Steven stevenMock = mock(Steven.class);
        Position initialPosition = new Position(1, 1);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroConMock.getModel().isLife(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().getSteven()).thenReturn(stevenMock);

        heroConMock.moveHeroDown();

        verify(stevenMock).increaseLifes();
    }
    @Test
    void testGetBombUp(){
        Steven stevenMock = mock(Steven.class);
        Position initialPosition = new Position(1, 1);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroConMock.getModel().isBombUpgrade(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().getSteven()).thenReturn(stevenMock);

        heroConMock.moveHeroDown();

        verify(stevenMock).setBombUp(true);
    }
    @Test
    void testGetUnlimitedUp(){
        Steven stevenMock = mock(Steven.class);
        Position initialPosition = new Position(1, 1);
        when(stevenMock.getPosition()).thenReturn(initialPosition);
        when(heroConMock.getModel().isUnlimitedBomb(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(heroConMock.getModel().getSteven()).thenReturn(stevenMock);

        heroConMock.moveHeroDown();

        verify(heroConMock.getModel()).setUnlimitedUp(true);
    }
}
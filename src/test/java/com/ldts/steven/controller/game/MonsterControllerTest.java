package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Monster;
import com.ldts.steven.model.game.elements.Steven;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class MonsterControllerTest {
    private MonsterController monsterConMock;
    private Game gameMock;
    private Position newPosition;
    @BeforeEach
    void setUp(){
        gameMock = mock(Game.class);
        Arena arenaMock = mock(Arena.class);
        monsterConMock = spy(new MonsterController(arenaMock)); // Use spy to partially mock the MonsterController
        newPosition = new Position(1, 2);

    }
    @Test
    void testMoveFollowerMonster() throws IOException {
        Monster monsterMock = mock(Monster.class);
        Steven stevenMock = mock(Steven.class);

        when(monsterConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(monsterConMock.getModel().getMonsters()).thenReturn(List.of(monsterMock));
        when(monsterConMock.getModel().getSteven()).thenReturn(stevenMock);
        when(monsterMock.isFollower()).thenReturn(true);
        when(monsterMock.getPosition()).thenReturn(newPosition);
        when(stevenMock.getPosition()).thenReturn(newPosition);
        monsterConMock.step(gameMock, GUI.ACTION.NONE, 501);

        verify(monsterConMock).moveFollowerMonster(any(), any());
        verify(monsterConMock).getNextPosition(any(), any());
    }
    @Test
    void testMoveNormalMonster() throws IOException {
        Monster monsterMock = mock(Monster.class);
        Steven stevenMock = mock(Steven.class);

        when(monsterConMock.getModel().isEmpty(Mockito.any(Position.class))).thenReturn(true);
        when(monsterConMock.getModel().getMonsters()).thenReturn(List.of(monsterMock));
        when(monsterConMock.getModel().getSteven()).thenReturn(stevenMock);
        when(monsterMock.getPosition()).thenReturn(newPosition);
        when(stevenMock.getPosition()).thenReturn(newPosition);
        monsterConMock.step(gameMock, GUI.ACTION.NONE, 501);

        verify(monsterConMock).moveNormalMonster(any(), any());
    }
}

package com.ldts.steven;

import com.ldts.steven.Game;
import com.ldts.steven.controller.game.ArenaController;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.end.Loser;
import com.ldts.steven.model.end.Winner;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Monster;
import com.ldts.steven.model.game.elements.Steven;
import com.ldts.steven.states.EndState;
import com.ldts.steven.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArenaControllerTest {
    private ArenaController arenaConMock;
    private Game gameMock;
    @BeforeEach
    void setUp() {
        gameMock = mock(Game.class);
        arenaConMock = new ArenaController(mock(Arena.class));
    }
    @Test
    void testQuitGame() throws IOException {
        arenaConMock.step(gameMock, GUI.ACTION.QUIT, 0);

        Mockito.verify(gameMock).setState(Mockito.any(MenuState.class));
    }
    @Test
    void testWinGame() throws IOException {
        // Configurar o estado da Arena para não ter monstros
        when(arenaConMock.getModel().getMonsters()).thenReturn(Collections.emptyList());

        arenaConMock.step(gameMock, GUI.ACTION.NONE, 0);

        Mockito.verify(gameMock).setState(Mockito.any(EndState.class));
        Mockito.verify(gameMock).setState(Mockito.argThat(argument ->
                argument instanceof EndState && ((EndState) argument).getModel() instanceof Winner
        ));
    }
    @Test
    void testLoseGame() throws IOException {
        // Configurar o estado da Arena para ter monstros
        when(arenaConMock.getModel().getMonsters()).thenReturn(Collections.singletonList(mock(Monster.class)));
        // Configurar o estado de Steven para ter 0 vidas
        when(arenaConMock.getModel().getSteven()).thenReturn(mock(Steven.class));
        when(arenaConMock.getModel().getSteven().getLifes()).thenReturn(0);

        arenaConMock.step(gameMock, GUI.ACTION.NONE, 0);

        Mockito.verify(gameMock).setState(Mockito.any(EndState.class));
        Mockito.verify(gameMock).setState(Mockito.argThat(argument ->
                argument instanceof EndState && ((EndState) argument).getModel() instanceof Loser
        ));
    }

}

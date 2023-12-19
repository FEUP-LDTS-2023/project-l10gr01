package com.ldts.steven.controller.menu;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.states.InstructionState;
import com.ldts.steven.states.SelectLevelState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuControllerTest {
    @Test
    void menuUsage() throws IOException {
        Game gameMock = mock(Game.class);
        Menu menuMock = mock(Menu.class);
        MenuController menuController = new MenuController(menuMock);


        menuController.step(gameMock, GUI.ACTION.UP, 0);
        verify(menuMock).previousEntry();

        menuController.step(gameMock, GUI.ACTION.DOWN, 0);
        verify(menuMock).nextEntry();

        when(menuMock.isSelectedExit()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).setState(null);

        when(menuMock.isSelectedInstruction()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).setState(any(InstructionState.class));

        when(menuMock.isSelectedStart()).thenReturn(true);
        menuController.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).setState(any(SelectLevelState.class));
    }
}

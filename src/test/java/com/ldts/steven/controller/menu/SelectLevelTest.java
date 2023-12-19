package com.ldts.steven.controller.menu;
import com.ldts.steven.Game;
import com.ldts.steven.controller.selectLevel.SelectLevelController;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.selectLevel.SelectLevel;
import com.ldts.steven.states.GameState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SelectLevelTest {
    @Test
    void selectLevel() throws IOException {
        Game gameMock = mock(Game.class);
        SelectLevel selectLevelMock = mock(SelectLevel.class);
        SelectLevelController selectLevelController = new SelectLevelController(selectLevelMock);


        selectLevelController.step(gameMock, GUI.ACTION.UP, 0);
        verify(selectLevelMock).previousEntry();

        selectLevelController.step(gameMock, GUI.ACTION.DOWN, 0);
        verify(selectLevelMock).nextEntry();

        when(selectLevelMock.isSelectedExit()).thenReturn(true);
        selectLevelController.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).setState(null);

        when(selectLevelMock.isSelectedLevelOne()).thenReturn(true);
        selectLevelController.step(gameMock, GUI.ACTION.SELECT, 100);
        verify(gameMock).setState(any(GameState.class));

    }
}
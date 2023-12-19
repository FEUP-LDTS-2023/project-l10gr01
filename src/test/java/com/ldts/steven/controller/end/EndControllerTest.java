package com.ldts.steven.controller.end;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.end.End;
import com.ldts.steven.states.MenuState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EndControllerTest {
    @Test
    void testGoToMenu() throws IOException {
        End endMock = mock(End.class);
        EndController endController = new EndController(endMock);
        Game gameMock = mock(Game.class);

        endController.step(gameMock, GUI.ACTION.SELECT, 1000);

        verify(gameMock).setState(any(MenuState.class));
    }
}

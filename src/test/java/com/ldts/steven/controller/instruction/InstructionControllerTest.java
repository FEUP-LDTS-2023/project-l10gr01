package com.ldts.steven.controller.instruction;
import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.instruction.Instruction;
import com.ldts.steven.states.MenuState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class InstructionControllerTest {
    @Test
    void testGoToMenu() throws IOException {
        Instruction insMock = mock(Instruction.class);
        InstructionController instructionController = new InstructionController(insMock);
        Game gameMock = mock(Game.class);

        instructionController.step(gameMock, GUI.ACTION.SELECT, 1000);

        verify(gameMock).setState(any(MenuState.class));
    }
}
package com.ldts.steven.controller.instruction;

import com.ldts.steven.Game;
import com.ldts.steven.controller.Controller;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.instruction.Instruction;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.states.MenuState;

import java.io.IOException;

public class InstructionController extends Controller<Instruction>{

    public InstructionController(Instruction instruction) {
        super(instruction);
    }

    @Override
        public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action== GUI.ACTION.SELECT) game.setState(new MenuState(new Menu()));
        }


}

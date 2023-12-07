package com.ldts.steven.controller.instruction;

import com.ldts.steven.Game;
import com.ldts.steven.controller.Controller;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.arena.LoaderArenaBuilder;
import com.ldts.steven.model.instruction.Instruction;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.states.GameState;
import com.ldts.steven.states.MenuState;

import java.io.IOException;

public class InstructionController extends Controller<Instruction>{

    public InstructionController(Instruction instruction) {
        super(instruction);
    }

    @Override
        public void step(Game game, GUI.ACTION action, long time) throws IOException {
            switch (action) {
                case UP:
                    getModel().previousEntry();
                    break;
                case DOWN:
                    getModel().nextEntry();
                    break;
                case SELECT:
                    if (getModel().isSelectedExit()) game.setState(new MenuState(new Menu()));
            }
        }


}

package com.ldts.steven.controller.menu;

import com.ldts.steven.Game;
import com.ldts.steven.controller.Controller;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.instruction.Instruction;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.model.selectLevel.SelectLevel;
import com.ldts.steven.states.InstructionState;
import com.ldts.steven.states.SelectLevelState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedInstruction()) game.setState(new InstructionState(new Instruction()));
                if (getModel().isSelectedStart()) game.setState(new SelectLevelState(new SelectLevel()));
        }
    }
}
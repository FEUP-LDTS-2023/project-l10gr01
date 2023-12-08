package com.ldts.steven.controller.winner;

import com.ldts.steven.Game;
import com.ldts.steven.controller.Controller;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.model.winner.Winner;
import com.ldts.steven.states.MenuState;

import java.io.IOException;

public class WinnerController extends Controller<Winner>{

    public WinnerController(Winner winner) {
        super(winner);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action== GUI.ACTION.SELECT) game.setState(new MenuState(new Menu()));
    }


}

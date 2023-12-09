package com.ldts.steven.controller.end;

import com.ldts.steven.Game;
import com.ldts.steven.controller.Controller;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.end.End;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.states.MenuState;

import java.io.IOException;

public class EndController extends Controller<End>{
    public EndController(End end) {
        super(end);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        //If game ends (win or lose), the player returns to the Menu.
        if(action== GUI.ACTION.SELECT) game.setState(new MenuState(new Menu()));
    }


}

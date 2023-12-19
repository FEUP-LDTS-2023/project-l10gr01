package com.ldts.steven.controller.selectLevel;

import com.ldts.steven.Game;
import com.ldts.steven.controller.Controller;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.arena.LoaderArenaBuilder;
import com.ldts.steven.model.selectLevel.SelectLevel;
import com.ldts.steven.states.GameState;
import java.io.IOException;

public class SelectLevelController extends Controller<SelectLevel> {

    public SelectLevelController(SelectLevel selectLevel) {
        super(selectLevel);
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
                if (getModel().isSelectedLevelOne()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                if (getModel().isSelectedLevelTwo()) game.setState(new GameState(new LoaderArenaBuilder(2).createArena()));
                if (getModel().isSelectedLevelThree()) game.setState(new GameState(new LoaderArenaBuilder(3).createArena()));

        }
    }

}

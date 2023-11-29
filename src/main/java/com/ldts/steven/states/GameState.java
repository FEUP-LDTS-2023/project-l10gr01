package com.ldts.steven.states;

import com.ldts.steven.controller.Controller;
import com.ldts.steven.controller.game.ArenaController;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.viewer.Viewer;
import com.ldts.steven.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }


}

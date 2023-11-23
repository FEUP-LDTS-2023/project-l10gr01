package com.ldts.steven.states;

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


}

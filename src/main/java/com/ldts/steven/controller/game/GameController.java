package com.ldts.steven.controller.game;

import com.ldts.steven.controller.Controller;
import com.ldts.steven.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}

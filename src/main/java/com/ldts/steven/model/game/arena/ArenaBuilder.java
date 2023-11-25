package com.ldts.steven.model.game.arena;

import com.ldts.steven.model.game.elements.BreakableWall;
import com.ldts.steven.model.game.elements.Steven;
import com.ldts.steven.model.game.elements.Monster;
import com.ldts.steven.model.game.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setSteven(createSteven());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setBreakableWalls(createBreakableWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Steven createSteven();
    protected abstract List<BreakableWall> createBreakableWalls();
}

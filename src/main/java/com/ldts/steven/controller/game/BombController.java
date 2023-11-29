package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Bomb;

public class BombController extends GameController{
    public BombController(Arena arena) {
        super(arena);
    }
    public void plantBomb(Position position){
        Bomb bomb = new Bomb(position.getX(), position.getY());
        getModel().addBomb(bomb);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        for (Bomb bomb : getModel().getBombs()) {
            bomb.update();}
    }
}

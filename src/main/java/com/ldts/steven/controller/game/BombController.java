package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Bomb;
import com.ldts.steven.model.game.elements.BreakableWall;

import java.util.ArrayList;
import java.util.List;

public class BombController extends GameController{
    private boolean hurtSteven;
    public BombController(Arena arena) {
        super(arena);
        hurtSteven = false;
    }
    public void plantBomb(Position position){
        Bomb bomb = new Bomb(position.getX(), position.getY());
        getModel().addBomb(bomb);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        List<Bomb> bombsToRemove = new ArrayList<>();
        List<BreakableWall> wallsToBreak = new ArrayList<>();
        for (Bomb bomb : getModel().getBombs()) {
            bomb.update();
            if(bomb.hasExploded() && getModel().isBomb(getModel().getSteven().getPosition()) && !hurtSteven) {
                getModel().getSteven().decreaseLifes();
                hurtSteven = true;
            }
            if(bomb.hasExploded()){
                for(BreakableWall breakableWall : getModel().getBreakableWalls()){
                    if(getModel().isBomb(breakableWall.getPosition())) wallsToBreak.add(breakableWall);
                }
            }
            for(BreakableWall breakableWall : wallsToBreak){
                getModel().breakWall(breakableWall);
            }
            if (bomb.getDisappear()) {
                bombsToRemove.add(bomb);
            }
        }
        for(Bomb bomb : bombsToRemove){
            getModel().removeBombs(bomb);
        }
    }
}

package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BombController extends GameController{
    private boolean hurtSteven;
    public BombController(Arena arena) {
        super(arena);
        hurtSteven = false;
    }
    public void plantBomb(Position position){
        if(getModel().getUpgrade()){
            Bomb bomb = new UpgradedBomb(position.getX(), position.getY());
            getModel().addBomb(bomb);
    }
        else{
            Bomb bomb = new NormalBomb(position.getX(), position.getY());
            getModel().addBomb(bomb);
        }
    }
    public void setHurtSteven(boolean flag){
        this.hurtSteven=flag;
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
                Random random = new Random();
                int numRandom = random.nextInt(100);

                if(numRandom < 10){
                    getModel().getUnlimitedBombs().add(new UnlimitedBombs(breakableWall.getPosition().getX(),breakableWall.getPosition().getY()));

                }else if(numRandom < 20){
                    getModel().getLifes().add(new Life(breakableWall.getPosition().getX(),breakableWall.getPosition().getY()));
                }else if(numRandom < 30){
                    getModel().getBombUpgrades().add(new BombUpgrade(breakableWall.getPosition().getX(),breakableWall.getPosition().getY()));

                }

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

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
    public boolean getHurtSteven(){
        return hurtSteven;
    }
    public void plantBomb(Position position){
        //Steven can plant two kinds of bombs. Upgraded bombs or normal bombs.
        if(getModel().getSteven().getBombUp()){
            Bomb bomb = new UpgradedBomb(position.getX(), position.getY());
            getModel().addBomb(bomb);
    }
        else{
            Bomb bomb = new NormalBomb(position.getX(), position.getY());
            getModel().addBomb(bomb);
        }
        setHurtSteven(true);
    }
    public void setHurtSteven(boolean flag){
        this.hurtSteven=flag;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        List<Bomb> bombsToRemove = new ArrayList<>();
        List<BreakableWall> wallsToBreak = new ArrayList<>();
        //When steven plants a bomb, we update its state to set a timer so the event of the explosion can have different states.
        for (Bomb bomb : getModel().getBombs()) {
            bomb.update();
            if(bomb.hasExploded() && getModel().isBomb(getModel().getSteven().getPosition()) && !hurtSteven) {
                getModel().getSteven().decreaseLifes();
                hurtSteven = true;
            }
            //The bomb can break certain types of walls, if the wall is in its radius.
            if(bomb.hasExploded()){
                for(BreakableWall breakableWall : getModel().getBreakableWalls()){
                    if(getModel().isBomb(breakableWall.getPosition())) wallsToBreak.add(breakableWall);
                }
            }
            for(BreakableWall breakableWall : wallsToBreak){
                getModel().breakWall(breakableWall);
                Random random = new Random();
                //When a wall is broken, it has 5% chance of having an upgrade.
                int numRandom = random.nextInt(100);

                if(numRandom < 5){
                    getModel().getUnlimitedBombs().add(new UnlimitedBombs(breakableWall.getPosition().getX(),breakableWall.getPosition().getY()));

                }else if(numRandom < 10){
                    getModel().getLifes().add(new Life(breakableWall.getPosition().getX(),breakableWall.getPosition().getY()));
                }else if(numRandom < 15){
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

package com.ldts.steven.model.game.elements;

public class BreakableWall extends Element{

    boolean hasBombUpgrade;

    public BreakableWall(int x, int y) {
        super(x,y);
        this.hasBombUpgrade = Math.random() > 0.80;
    }

    public boolean hasBombUpgrade(){
        return hasBombUpgrade;
    }
}

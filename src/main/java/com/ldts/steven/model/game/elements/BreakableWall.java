package com.ldts.steven.model.game.elements;

public class BreakableWall extends Element{

    boolean hasBombUpgrade;
    boolean hasUnlimitedBomb;

    public BreakableWall(int x, int y) {
        super(x,y);
        this.hasBombUpgrade = Math.random() > 0.95;
        this.hasUnlimitedBomb = Math.random() > 0.95;
    }

    public boolean HasUnlimitedBomb() {
        return hasUnlimitedBomb;
    }

    public boolean hasBombUpgrade(){
        return hasBombUpgrade;
    }


}

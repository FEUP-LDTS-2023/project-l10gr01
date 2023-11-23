package com.ldts.steven.model.game.elements;

public class Steven extends Element{
    private int lifes;

    public Steven(int x, int y) {
        super(x, y);
        this.lifes= 3;
    }

    public void decreaseEnergy() {
        this.lifes--;
    }

    public int getEnergy() {
        return lifes;
    }

}

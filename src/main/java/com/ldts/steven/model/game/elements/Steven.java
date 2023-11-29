package com.ldts.steven.model.game.elements;

public class Steven extends Element{
    private int lifes;

    public Steven(int x, int y) {
        super(x, y);
        this.lifes= 3;
    }

    public void decreaseLifes() {
        this.lifes--;
    }

    public int getLifes() {
        return lifes;
    }

}

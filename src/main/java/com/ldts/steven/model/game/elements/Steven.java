package com.ldts.steven.model.game.elements;

public class Steven extends Element{
    private int lifes;
    public boolean bombUp;
    public long getBombUpTime;
    public Steven(int x, int y) {
        super(x, y);
        this.lifes= 3;
        this.bombUp=false;
    }

    public void decreaseLifes() {
        this.lifes--;
    }

    public int getLifes() {
        return lifes;
    }
    public void setBombUp(boolean upgrade) {
        this.bombUp = upgrade;
        this.getBombUpTime = System.currentTimeMillis();
    }
    public void stopBombUp(long actualTime) {
        if (actualTime - getBombUpTime > 15000) this.bombUp=false;
    }
    public void increaseLifes() {
        if(lifes < 3) this.lifes++;
    }
}

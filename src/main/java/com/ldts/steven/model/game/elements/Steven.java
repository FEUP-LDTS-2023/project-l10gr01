package com.ldts.steven.model.game.elements;

public class Steven extends Element{
    private int lifes;
    public boolean bombUp;
    public long getBombUpTime;
    public String color;
    public Steven(int x, int y) {
        super(x, y);
        this.lifes= 3;
        this.bombUp=false;
        this.color="#FFEB48";
    }

    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return this.color;
    }
    public void decreaseLifes() {
        this.lifes--;
    }
    public boolean getBombUp() {return bombUp;}

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

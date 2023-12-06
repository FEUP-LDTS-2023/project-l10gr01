package com.ldts.steven.model.game.elements;

import com.ldts.steven.model.Position;

import java.util.Vector;

public abstract class Bomb extends Element {

    private boolean exploded;
    private long plantTime;
    private boolean disappear;
    protected int explosionRadius;
    public Vector<Position> canBombExplode;

    public Bomb(int x, int y) {
        super(x,y);
        this.canBombExplode = new Vector<>();
        this.exploded = false;
        this.disappear = false;
    }

    public void explode() {
    }

    public void disappear() {
    }

    public void update() {
    }
    public int getExplosionRadius(){
        return explosionRadius;
    }

    public void addCanBombExplode(Position position) {
    }

    public Vector<Position> getCanBombExplode() {
        return canBombExplode;
    }

    public boolean hasExploded() {
        return exploded;
    }

    public boolean getDisappear() {
        return disappear;
    }


}

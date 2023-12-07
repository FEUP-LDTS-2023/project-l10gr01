package com.ldts.steven.model.game.elements;

import com.ldts.steven.model.Position;

import java.util.Vector;

public class NormalBomb extends Bomb {
    private boolean exploded;
    protected int explosionRadius;
    private long plantTime;
    private boolean disappear;
    public Vector<Position> canBombExplode;

    public NormalBomb(int x, int y) {
        super(x, y);
        this.exploded = false;
        this.explosionRadius = 2;
        this.plantTime = System.currentTimeMillis();
        this.canBombExplode = new Vector<>();
    };

    @Override
    public void explode() {
        this.exploded = true;
    }
    @Override
    public void disappear() {this.disappear = true;}
    @Override
    public void update() {
        // Verifique se o tempo decorrido é suficiente para a explosão
        long currentTime = System.currentTimeMillis();
        if ((currentTime - plantTime > 3000) && currentTime-plantTime < 5000) { // 3 segundos
            explode();
        } else if (currentTime - plantTime > 5000) { // 6 segundos (3 segundos após a explosão)
            disappear();
        }
    }
    @Override
    public boolean hasExploded() {
        return exploded;
    }
    @Override
    public boolean getDisappear(){return disappear;}

    @Override
    public void addCanBombExplode(Position position){
        canBombExplode.add(position);
    }
    @Override
    public Vector<Position> getCanBombExplode(){
        return canBombExplode;
    }
    public int getExplosionRadius(){
        return explosionRadius;
    }

}

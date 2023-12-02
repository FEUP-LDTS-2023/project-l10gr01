package com.ldts.steven.model.game.elements;

import com.ldts.steven.model.Position;

import java.util.Vector;

public class Bomb extends Element{
    private boolean exploded;
    private int explosionRadius;
    private long plantTime;
    private boolean disappear;
    public Vector<Position> canBombExplode;

    public Bomb(int x, int y) {
        super(x, y);
        this.exploded = false;
        this.explosionRadius = 3; // Pode mudar se tiver com poderes, etc.
        this.plantTime = System.currentTimeMillis();
        this.canBombExplode = new Vector<>();
    };

    private void explode() {
        this.exploded = true;
    }
    private void disappear() {this.disappear = true;}

    public void update() {
        // Verifique se o tempo decorrido é suficiente para a explosão
        long currentTime = System.currentTimeMillis();
        if ((currentTime - plantTime > 3000) && currentTime-plantTime < 6000) { // 3 segundos
            explode();
        } else if (currentTime - plantTime > 6000) { // 6 segundos (3 segundos após a explosão)
            disappear();
        }
    }
    public boolean hasExploded() {
        return exploded;
    }
    public boolean getDisappear(){return disappear;}
    public int getExplosionRadius() {
        return explosionRadius;
    }


    public void setExplosionRadius(int explosionRadius) {
        this.explosionRadius = explosionRadius;
    }
}

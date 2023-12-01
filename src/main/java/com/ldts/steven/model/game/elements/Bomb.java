package com.ldts.steven.model.game.elements;

import com.ldts.steven.model.Position;

import java.util.Vector;

public class Bomb extends Element{
    private boolean exploded;
    private int explosionRadius;
    private long plantTime;

    public Vector<Position> canBombExplode;

    public Bomb(int x, int y) {
        super(x, y);
        this.exploded = false;
        this.explosionRadius = 3; // Pode mudar se tiver com poderes, etc.
        this.plantTime = System.currentTimeMillis();
    };

    private void explode() {
        this.exploded = true;
    }
    public void update() {
        // Verifique se o tempo decorrido é suficiente para a explosão
        long currentTime = System.currentTimeMillis();
        if (currentTime - plantTime > 3000) { // 3 segundos
            explode();
        }
    }
    public boolean hasExploded() {
        return exploded;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }

    public void setExplosionRadius(int explosionRadius) {
        this.explosionRadius = explosionRadius;
    }
}

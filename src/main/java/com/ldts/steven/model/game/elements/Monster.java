package com.ldts.steven.model.game.elements;

public abstract class Monster extends Element{
    public boolean follower;
    public Monster(int x, int y) {
        super(x, y);
    }

    public boolean isFollower(){
        return follower;
    }
}

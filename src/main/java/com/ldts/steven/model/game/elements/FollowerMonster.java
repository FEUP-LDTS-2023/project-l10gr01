package com.ldts.steven.model.game.elements;

public class FollowerMonster extends Monster {
    public FollowerMonster(int x, int y) {
        super(x, y);
        super.follower=true;
    }
}

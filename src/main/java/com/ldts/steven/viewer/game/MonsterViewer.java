package com.ldts.steven.viewer.game;


import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {

        if(!monster.follower)gui.drawNormalMonster(monster.getPosition());
        else gui.drawFollowerMonster(monster.getPosition());
    }
}

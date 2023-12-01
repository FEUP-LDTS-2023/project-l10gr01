package com.ldts.steven.viewer.game;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.elements.Bomb;

public class BombViewer implements ElementViewer<Bomb> {
    @Override
    public void draw(Bomb bomb, GUI gui) {
        if(!bomb.hasExploded()) gui.drawBomb(bomb.getPosition());
        else {
            for(Position pos : bomb.canBombExplode){
                gui.drawBombExploded(pos);
            }
        }
    }
}
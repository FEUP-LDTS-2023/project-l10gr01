package com.ldts.steven.viewer.game;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.elements.Life;

public class LifeViewer implements ElementViewer<Life>{
    @Override
    public void draw(Life life, GUI gui) {
        gui.drawLife(life.getPosition());
    }
}

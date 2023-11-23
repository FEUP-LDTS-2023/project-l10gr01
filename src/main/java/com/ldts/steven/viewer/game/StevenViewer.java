package com.ldts.steven.viewer.game;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.elements.Steven;

public class StevenViewer implements ElementViewer<Steven> {
    @Override
    public void draw(Steven steven, GUI gui) {
        gui.drawHero(steven.getPosition());
    }
}

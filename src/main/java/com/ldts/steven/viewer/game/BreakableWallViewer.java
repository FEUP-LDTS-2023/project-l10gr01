package com.ldts.steven.viewer.game;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.elements.BreakableWall;

public class BreakableWallViewer implements ElementViewer<BreakableWall> {
    @Override
    public void draw(BreakableWall breakableWall, GUI gui) {
        gui.drawBreakableWall(breakableWall.getPosition());
    }
}

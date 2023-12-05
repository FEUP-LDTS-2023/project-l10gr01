package com.ldts.steven.viewer.game;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.elements.Element;
import com.ldts.steven.model.game.elements.UnlimitedBombs;

public class UnlimitedBombsViewer implements ElementViewer<UnlimitedBombs> {
    @Override
    public void draw(UnlimitedBombs unlimitedBombs, GUI gui) {
        gui.drawUnlimitedBomb(unlimitedBombs.getPosition());
    }
}

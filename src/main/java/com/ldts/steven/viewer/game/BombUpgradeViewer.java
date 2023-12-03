package com.ldts.steven.viewer.game;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.elements.Bomb;
import com.ldts.steven.model.game.elements.BombUpgrade;

public class BombUpgradeViewer implements ElementViewer<BombUpgrade>{
    @Override
    public void draw(BombUpgrade bombUpgrade, GUI gui) {
        gui.drawBombUpgrade(bombUpgrade.getPosition());
    }
}

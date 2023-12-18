package com.ldts.steven.viewer.game;


import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Bomb;
import com.ldts.steven.model.game.elements.Element;
import com.ldts.steven.model.game.elements.Life;
import com.ldts.steven.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getSteven(), new StevenViewer());
        drawElements(gui, getModel().getBreakableWalls(), new BreakableWallViewer());
        drawElements(gui,getModel().getLifes(), new LifeViewer());
        drawElements(gui, getModel().getBombs(), new BombViewer());
        if(!getModel().getBombUpgrades().isEmpty())
            drawElements(gui, getModel().getBombUpgrades(), new BombUpgradeViewer());
        if(!getModel().getUnlimitedBombs().isEmpty())
            drawElements(gui,getModel().getUnlimitedBombs(), new UnlimitedBombsViewer());
        if(!getModel().getLifes().isEmpty()){
            drawElements(gui,getModel().getLifes(), new LifeViewer());
        }
        if(getModel().getSteven().bombUp){
            gui.drawText(new Position(13, 0), "Bomb Upgrade", "#FF6700");
        }
        if(getModel().unlimitedUp){
            gui.drawText(new Position(31, 0), "Unlimited Bombs", "#1FC1DB");
        }
        gui.drawText(new Position(0, 0), "LIFES: " + getModel().getSteven().getLifes(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}

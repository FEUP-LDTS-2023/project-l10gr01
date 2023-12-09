package com.ldts.steven.viewer.selectLevel;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.selectLevel.SelectLevel;
import com.ldts.steven.viewer.Viewer;

public class SelectLevelViewer extends Viewer<SelectLevel> {

    public SelectLevelViewer(SelectLevel selectLevel) {
        super(selectLevel);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "SELECT LEVEL", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }

}

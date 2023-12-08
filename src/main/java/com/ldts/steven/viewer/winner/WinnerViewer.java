package com.ldts.steven.viewer.winner;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.instruction.Instruction;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.model.winner.Winner;
import com.ldts.steven.viewer.Viewer;

public class WinnerViewer extends Viewer<Winner> {


    public WinnerViewer(Winner winner) {
        super(winner);
    }

    @Override
    public void drawElements(GUI gui) {

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            String entry = getModel().getEntry(i);
            String color = "#FFFFFF";

            if (i == 2) {
                color = "#FFFFFF";}
            else if (i == 3) {
                color = "#FFFFFF";
            }
            else if (i == 4) {
                color = "#FFFFFF";
            }else if (i == 5) {
                color = "#FFFFFF";
            }
            else if (i == 6) {
                color = "#FFFFFF";
            }
            else if (i == 7) {
                color = "#FFFFFF";
            }
            else if (i == 11) {
                color = "#FFD700";
            }

            gui.drawText(new Position(15, 7 + i), entry, color);
        }
}}

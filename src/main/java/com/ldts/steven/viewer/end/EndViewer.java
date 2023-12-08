package com.ldts.steven.viewer.end;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.end.End;
import com.ldts.steven.model.end.Winner;
import com.ldts.steven.viewer.Viewer;

public class EndViewer extends Viewer<End> {


    public EndViewer(End end) {
        super(end);
    }
    @Override
    public void drawElements(GUI gui) {
        if(this.getModel().win) {
            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                String entry = getModel().getEntry(i);
                String color = "#FFFFFF";

                if (i == 2) {
                    color = "#FFFFFF";
                } else if (i == 3) {
                    color = "#FFFFFF";
                } else if (i == 4) {
                    color = "#FFFFFF";
                } else if (i == 5) {
                    color = "#FFFFFF";
                } else if (i == 6) {
                    color = "#FFFFFF";
                } else if (i == 7) {
                    color = "#FFFFFF";
                } else if (i == 11) {
                    color = "#FFD700";
                }

                gui.drawText(new Position(15, 7 + i), entry, color);
            }
        }
        else{
            for (int i = 0; i < getModel().getNumberEntries(); i++) {
                String entry = getModel().getEntry(i);
                String color = "#FF0000";

                if (i == 2) {
                    color = "#FF0000";
                } else if (i == 3) {
                    color = "#FF0000";
                } else if (i == 4) {
                    color = "#FF0000";
                } else if (i == 5) {
                    color = "#FF0000";
                } else if (i == 6) {
                    color = "#FF0000";
                } else if (i == 7) {
                    color = "#FF0000";
                } else if (i == 11) {
                    color = "#FFD700";
                }

                gui.drawText(new Position(15, 7 + i), entry, color);
            }
        }
}}

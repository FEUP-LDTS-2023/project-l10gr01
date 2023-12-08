package com.ldts.steven.viewer.instruction;

import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.instruction.Instruction;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.viewer.Viewer;

public class InstructionViewer extends Viewer<Instruction> {


    public InstructionViewer(Instruction instruction) {
        super(instruction);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(15, 5), "Instructions", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            String entry = getModel().getEntry(i);
            String color = "#FFFFFF";

            if (i == 8) {
                color = "#90FF5D";}
            else if (i == 9) {
                color = "#021EAA";
            }
            else if (i == 10) {
                color = "#FFEB48";
            }else if (i == 11) {
                color = "#E6D4A2";
            }
            else if (i == 12) {
                color = "#FF6700";
            }
            else if (i == 13) {
                color = "#B026FF";
            }
            else if (i == 17) {
                color = "#FFD700";
            }

            gui.drawText(new Position(15, 7 + i), entry, color);
        }
    }
}

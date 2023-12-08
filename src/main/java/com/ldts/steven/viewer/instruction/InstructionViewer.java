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
                color = "#00FF00";
            } else if (i == 14) {
                color = "#FFD700";  // Change color for the third line
            }

            gui.drawText(new Position(15, 7 + i), entry, color);
        }
    }
}

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

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(15, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

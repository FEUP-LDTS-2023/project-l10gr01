package com.ldts.steven.states;

import com.ldts.steven.controller.Controller;
import com.ldts.steven.controller.instruction.InstructionController;
import com.ldts.steven.model.instruction.Instruction;
import com.ldts.steven.viewer.Viewer;
import com.ldts.steven.viewer.instruction.InstructionViewer;


public class InstructionState extends State<Instruction> {
    public InstructionState(Instruction instruction) {
        super(instruction);
    }

    @Override
    protected Controller<Instruction> getController() {
        return new InstructionController(getModel());
    }


    @Override
    protected Viewer<Instruction> getViewer() {
        return new InstructionViewer(getModel());
    }


}

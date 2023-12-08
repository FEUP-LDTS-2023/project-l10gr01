package com.ldts.steven.states;

import com.ldts.steven.controller.Controller;
import com.ldts.steven.controller.end.EndController;
import com.ldts.steven.model.end.End;
import com.ldts.steven.viewer.Viewer;
import com.ldts.steven.viewer.end.EndViewer;


public class EndState extends State<End> {
    public EndState(End end) {
        super(end);
    }

    @Override
    protected Controller<End> getController() {
        return new EndController(getModel());
    }


    @Override
    protected Viewer<End> getViewer() { return new EndViewer(getModel()); }


}

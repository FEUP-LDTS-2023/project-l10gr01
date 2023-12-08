package com.ldts.steven.states;

import com.ldts.steven.controller.Controller;
import com.ldts.steven.controller.winner.WinnerController;
import com.ldts.steven.model.winner.Winner;
import com.ldts.steven.viewer.Viewer;
import com.ldts.steven.viewer.winner.WinnerViewer;


public class WinnerState extends State<Winner> {
    public WinnerState(Winner winner) {
        super(winner);
    }

    @Override
    protected Controller<Winner> getController() {
        return new WinnerController(getModel());
    }


    @Override
    protected Viewer<Winner> getViewer() { return new WinnerViewer(getModel()); }


}

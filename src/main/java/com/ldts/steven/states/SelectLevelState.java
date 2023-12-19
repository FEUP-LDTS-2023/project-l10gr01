package com.ldts.steven.states;

import com.ldts.steven.controller.Controller;
import com.ldts.steven.controller.selectLevel.SelectLevelController;
import com.ldts.steven.model.selectLevel.SelectLevel;
import com.ldts.steven.viewer.Viewer;
import com.ldts.steven.viewer.selectLevel.SelectLevelViewer;

public class SelectLevelState extends State<SelectLevel>{

    public SelectLevelState(SelectLevel selectLevel) {
        super(selectLevel);

    }

    @Override
    protected Controller<SelectLevel> getController() {
        return new SelectLevelController(getModel());
    }


    @Override
    protected Viewer<SelectLevel> getViewer() {
        return new SelectLevelViewer(getModel());
    }

}

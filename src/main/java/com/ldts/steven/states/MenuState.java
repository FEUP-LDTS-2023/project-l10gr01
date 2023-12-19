package com.ldts.steven.states;

import com.ldts.steven.controller.Controller;
import com.ldts.steven.controller.menu.MenuController;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.viewer.Viewer;
import com.ldts.steven.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);

    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }


    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }


}

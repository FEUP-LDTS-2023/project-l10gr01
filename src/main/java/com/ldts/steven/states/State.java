package com.ldts.steven.states;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;

    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
    }

    protected abstract Viewer<T> getViewer();

    public void step(Game game, GUI gui, long time) throws IOException {
        viewer.draw(gui);
    }

    public T getModel() {
        return model;
    }

}

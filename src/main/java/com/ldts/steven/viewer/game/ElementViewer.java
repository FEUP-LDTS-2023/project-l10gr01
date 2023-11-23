package com.ldts.steven.viewer.game;



import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

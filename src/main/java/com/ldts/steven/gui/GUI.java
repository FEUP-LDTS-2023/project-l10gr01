package com.ldts.steven.gui;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.steven.model.Position;

import java.io.IOException;
public interface GUI {
    void drawHero(Position position, String color);

    void drawWall(Position position);

    void drawNormalMonster(Position position);
    void drawFollowerMonster(Position position);
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawBreakableWall(Position position);

    void drawLife(Position position);
    void drawBomb(Position position);
    void drawBombExploded(Position position);
    void drawText(Position position, String text, String color);

    void drawBombUpgrade(Position position);

    void drawUnlimitedBomb(Position position);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SPACE}

    ACTION getNextAction() throws IOException;

}

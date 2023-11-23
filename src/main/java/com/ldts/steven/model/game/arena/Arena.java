package com.ldts.steven.model.game.arena;
import com.ldts.steven.model.game.elements.Steven;
import com.ldts.steven.model.game.elements.Monster;
import com.ldts.steven.model.game.elements.Wall;

import java.util.List;

public class Arena {
    private int width;
    private int height;

    private Steven steven;
    private List<Monster> monsters;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public Steven getSteven() {
        return steven;
    }

    public void setSteven(Steven steven) {
        this.steven = steven;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

package com.ldts.steven.model.game.arena;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.elements.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arena {
    private int width;
    private int height;

    private Steven steven;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<BreakableWall> breakableWalls;

    private List<Life> lifes;
    private List<Bomb> bombs;

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        this.bombs = new ArrayList<>();
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

    public List<Life> getLifes() {
        return lifes;
    }

    public void eraseLife(Position position) {
        for (int i = 0; i < lifes.size(); i++) {
            if (lifes.get(i).getPosition().equals(position) && steven.getLifes() < 3) {
                lifes.remove(i);
            }

        }

    }

    public void setLifes(List<Life> lifes) {
        this.lifes = lifes;
    }

    public List<BreakableWall> getBreakableWalls() {
        return breakableWalls;
    }

    public void setBreakableWalls(List<BreakableWall> breakableWalls) {
        this.breakableWalls = breakableWalls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (BreakableWall wall : breakableWalls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isLife(Position position) {
        for (Life life : lifes) {
            if (life.getPosition().equals(position))
                return true;
        }
        return false;
    }
    public void killMonster(Monster monster){
        List<Monster> updatedMonsters = new ArrayList<>();

        for (Monster currentMonster : monsters) {
            if (!currentMonster.equals(monster)) {
                updatedMonsters.add(currentMonster);
                // Adicione aqui qualquer outra lógica relacionada à eliminação do monstro
            }
        }
        // Atualize a lista original com a nova lista de monstros
        monsters = updatedMonsters;
    }
    public void breakWall(BreakableWall wall){;}

    public boolean isBomb(Position position) {
        for (Bomb bomb : bombs) {
            if(!bomb.hasExploded()) return false;
            int bombX = bomb.getPosition().getX();
            int bombY = bomb.getPosition().getY();
            int positionX = position.getX();
            int positionY = position.getY();

            // Verifique se a posição está dentro do raio de explosão (considerando um raio de 3)
            if (Math.abs(bombX - positionX) <= 3 && Math.abs(bombY - positionY) <= 3) {
                return true;
            }
        }
        return false;
    }

    public void addBomb(Bomb bomb) {
        bombs.add(bomb);
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void updateBombs() {
        bombs.removeIf(Bomb::hasExploded);
    }
}

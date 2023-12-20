package com.ldts.steven.model.game.arena;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.elements.*;

import java.util.*;

public class Arena {
    private int width;
    private int height;

    private Steven steven;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<BreakableWall> breakableWalls;
    public long unlimitedUpTime;
    public boolean unlimitedUp;
    private List<Life> lifes;
    private List<Bomb> bombs;
    private int maxBombs;

    private List<BombUpgrade> bombUpgrades;

    private List<UnlimitedBombs> unlimitedBombs;

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        this.bombs = new ArrayList<>();
        this.bombUpgrades = new ArrayList<>();
        this.unlimitedBombs = new ArrayList<>();
        this.lifes = new ArrayList<>();
        this.maxBombs = 1;
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

    public void setLifes(List<Life> lifes){this.lifes = lifes;}

    public void eraseLife(Position position) {
        for (int i = 0; i < lifes.size(); i++) {
            if (lifes.get(i).getPosition().equals(position) && steven.getLifes() < 3) {
                lifes.remove(i);
            }
        }
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
        for (Bomb bomb : bombs){
            if (bomb.getPosition().equals(position) && !bomb.hasExploded())
                return false;
        }
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isWall(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
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

    public boolean isBombUpgrade(Position position) {
        for (BombUpgrade b : bombUpgrades) {
            if (b.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public boolean isUnlimitedBomb(Position position){
        for(UnlimitedBombs b : unlimitedBombs){
            if(b.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public void removeBombUpgrade(Position position) {
        for (BombUpgrade b : bombUpgrades) {
            if (b.getPosition().equals(position)) {
                bombUpgrades.remove(b);
                break;
            }
        }
    }

    public void removeUnlimitedBomb(Position position) {
        for (UnlimitedBombs b : unlimitedBombs) {
            if (b.getPosition().equals(position)) {
                unlimitedBombs.remove(b);
                break;
            }
        }
    }

    public void killMonster(Position position){
        List<Monster> updatedMonsters = new ArrayList<>();

        for (Monster currentMonster : monsters) {
            if (!currentMonster.getPosition().equals(position)) {
                updatedMonsters.add(currentMonster);
            }
        }
        monsters = updatedMonsters;
    }

    public boolean isBomb(Position position) {
        for (Bomb bomb : bombs) {
            Vector<Position> aux = bomb.getCanBombExplode();
            if (bomb.hasExploded() && aux.contains(position)) {
                return true;
            }
        }
        return false;
    }
    public void addBomb(Bomb bomb) {

        //When a bomb is added its explosion happens in xy axis.
        int x = bomb.getPosition().getX();
        int y = bomb.getPosition().getY();
        int explosionRadius = bomb.getExplosionRadius();

        for(int i=x; i <= x+explosionRadius; i++){
            Position aux = new Position(i, y);
            if(isWall(aux)) break;
            bomb.addCanBombExplode(aux);
        }
        for(int i=x; i >= x-explosionRadius; i--){
            Position aux = new Position(i, y);
            if(isWall(aux)) break;
            bomb.addCanBombExplode(aux);
        }
        for(int i=y; i <= y+explosionRadius; i++){
            Position aux = new Position(x, i);
            if(isWall(aux)) break;
            bomb.addCanBombExplode(aux);
        }
        for(int i=y; i >= y-explosionRadius; i--){
            Position aux = new Position(x, i);
            if(isWall(aux)) break;
            bomb.addCanBombExplode(aux);
        }
        if(bombs.size() < maxBombs)
            bombs.add(bomb);
    }
    public int getMaxBombs(){
        return maxBombs;
    }
    public void breakWall(BreakableWall wall){
        breakableWalls.remove(wall);


    }

    public List<BombUpgrade> getBombUpgrades() {
        return bombUpgrades;
    }

    public List<UnlimitedBombs> getUnlimitedBombs() {
        return unlimitedBombs;
    }

    public void setMaxBombs(int maxBombs) {
        this.maxBombs = maxBombs;
    }

    public void removeBombs(Bomb bomb){
        bombs.remove(bomb);
    }
    public List<Bomb> getBombs() {
        return bombs;
    }
    public void setUnlimitedUp(boolean upgrade){
        this.unlimitedUp=upgrade;
        this.unlimitedUpTime=System.currentTimeMillis();
        setMaxBombs(1000);
    }
    public void checkUnlimitedUp(long actualTime){
        if (actualTime - unlimitedUpTime > 15000){
            this.unlimitedUp=false;
            setMaxBombs(1);
        }
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public void setBombUpgrades(List<BombUpgrade> bombUpgrades) {
        this.bombUpgrades = bombUpgrades;
    }

    public void setUnlimitedBombs(List<UnlimitedBombs> unlimitedBombs) {
        this.unlimitedBombs = unlimitedBombs;
    }
}

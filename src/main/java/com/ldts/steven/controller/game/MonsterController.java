package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Monster;

import java.io.IOException;

public class MonsterController extends GameController {
    private long lastMovement;

    public MonsterController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters()) {
                if(monster.follower) {
                    Position stevenPosition = getModel().getSteven().getPosition();
                    Position monsterPosition = monster.getPosition();
                    Position nextPosition = getNextPosition(monsterPosition, stevenPosition);

                    moveFollowerMonster(monster, nextPosition);
                }
                else{
                    moveNormalMonster(monster, monster.getPosition().getRandomNeighbour());
                }
            }
            this.lastMovement = time;
        }
    }

    private Position getNextPosition(Position current, Position target) {
        int dx = Integer.compare(target.getX(), current.getX());
        int dy = Integer.compare(target.getY(), current.getY());

        Position nextPosition = new Position(current.getX() + dx, current.getY() + dy);

        if (Math.random() < 0.5) {
            dx = (int) Math.signum(Math.random() - 0.5);
            dy = 0;
        } else {
            dx = 0;
            dy = (int) Math.signum(Math.random() - 0.5);
        }

        return new Position(nextPosition.getX() + dx, nextPosition.getY() + dy);
    }
    private void moveFollowerMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getSteven().getPosition().equals(position))
                getModel().getSteven().decreaseLifes();
            if(getModel().isBomb(position) || getModel().isBomb(monster.getPosition())){
                getModel().killMonster(monster.getPosition());
            }
        }
    }
    private void moveNormalMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getSteven().getPosition().equals(position))
                getModel().getSteven().decreaseLifes();
            if(getModel().isBomb(position) || getModel().isBomb(monster.getPosition())){
                getModel().killMonster(position);
            }
        }
    }

}

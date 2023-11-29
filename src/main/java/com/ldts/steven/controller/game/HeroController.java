package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Bomb;

public class HeroController extends GameController {

    private BombController bombController;
    public HeroController(Arena arena, BombController bombController) {
        super(arena);
        this.bombController=bombController;
    }

    public void moveHeroLeft() {
        moveHero(getModel().getSteven().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getSteven().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getSteven().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getSteven().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getSteven().setPosition(position);
            if (getModel().isMonster(position) || getModel().isBomb(position)) getModel().getSteven().decreaseLifes();
            if (getModel().isLife(position)) {
                getModel().eraseLife(position);
                getModel().getSteven().increaseLifes();
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
        if (action == GUI.ACTION.SPACE) {
            Position heroPosition = getModel().getSteven().getPosition();
            bombController.plantBomb(heroPosition);
        }
    }
}

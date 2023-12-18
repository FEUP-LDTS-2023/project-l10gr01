package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.BreakableWall;

public class HeroController extends GameController {

    private final BombController bombController;
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
        /*Move hero is used to check Steven's location in the arena, several events can happen.
        Steven can be hurt when in contact with a monster, however he can regain his lost lives with a life upgrade.
        Also, if steven finds a bomb upgrade he can plant unlimited bombs or\and plant bombs with a bigger radius.
         */
        if (getModel().isEmpty(position)) {
            getModel().getSteven().setPosition(position);
            if (getModel().isMonster(position) || getModel().isBomb(position)) {
                bombController.setHurtSteven(true);
                getModel().getSteven().decreaseLifes();
            }
            if (getModel().isLife(position)) {
                getModel().eraseLife(position);
                getModel().getSteven().increaseLifes();
            }
            if(getModel().isBombUpgrade(position)){
                getModel().getSteven().setBombUp(true);
                getModel().removeBombUpgrade(position);
            }
            if(getModel().isUnlimitedBomb(position)){
                getModel().setUnlimitedUp(true);
                getModel().removeUnlimitedBomb(position);
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
        if(getModel().unlimitedUp && getModel().getSteven().bombUp){
            if(getModel().unlimitedUpTime>getModel().getSteven().getBombUpTime){
                getModel().getSteven().setColor("#1FC1DB");
            }
            else getModel().getSteven().setColor("#FF6700");
        }
        else if(getModel().unlimitedUp) getModel().getSteven().setColor("#1FC1DB");
        else if(getModel().getSteven().bombUp) getModel().getSteven().setColor("#FF6700");
        else getModel().getSteven().setColor("#FFEB48");
        getModel().getSteven().stopBombUp(System.currentTimeMillis());
        getModel().checkUnlimitedUp(System.currentTimeMillis());
    }
}

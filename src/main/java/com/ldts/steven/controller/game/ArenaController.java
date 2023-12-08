package com.ldts.steven.controller.game;

import com.ldts.steven.Game;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.end.Loser;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.model.end.Winner;
import com.ldts.steven.states.MenuState;
import com.ldts.steven.states.EndState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;
    private final BombController bombController;

    public ArenaController(Arena arena) {
        super(arena);

        this.monsterController = new MonsterController(arena);
        this.bombController = new BombController(arena);
        this.heroController = new HeroController(arena, bombController);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else if(getModel().getMonsters().isEmpty()){
            game.setState(new EndState(new Winner()));
        }
        else if(getModel().getSteven().getLifes() == 0){
            game.setState(new EndState(new Loser()));
        }
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
            bombController.step(game,action,time);
        }
    }
}
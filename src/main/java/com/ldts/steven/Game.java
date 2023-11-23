package com.ldts.steven;

import com.ldts.steven.gui.LanternaGUI;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.arena.LoaderArenaBuilder;
import com.ldts.steven.states.GameState;
import com.ldts.steven.states.MenuState;
import com.ldts.steven.states.State;

import com.ldts.steven.model.menu.Menu;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Game {
        private final LanternaGUI gui;
        private State state;

        public Game() throws FontFormatException, IOException, URISyntaxException {
            this.gui = new LanternaGUI(25, 25);
            this.state = new MenuState(new Menu());
        }

        public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
            new Game().start();
            Game game = new Game();
            game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
            game.start();
        }

        public void setState(State state) {
            this.state = state;
        }

        private void start() throws IOException {
            int FPS = 10;
            int frameTime = 1000 / FPS;

            while (this.state != null) {
                long startTime = System.currentTimeMillis();

                state.step(this,gui,startTime);

                long elapsedTime = System.currentTimeMillis() - startTime;
                long sleepTime = frameTime - elapsedTime;

                Scanner s = new Scanner(System.in);
                System.out.println("To exit press q: ");
                String read = s.nextLine();

                if(read.equals("q")) break;
                try {
                    if (sleepTime > 0) Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                }
            }

            gui.close();

        }
    }


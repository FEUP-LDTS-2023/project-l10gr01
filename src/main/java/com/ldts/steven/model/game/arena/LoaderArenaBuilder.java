package com.ldts.steven.model.game.arena;

import com.ldts.steven.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(Objects.requireNonNull(resource).getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }
    @Override
    protected List<BreakableWall> createBreakableWalls() {
        List<BreakableWall> breakablewalls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '%') breakablewalls.add(new BreakableWall(x, y));
        }

        return breakablewalls;
    }



    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'M') {
                    Monster monster = new NormalMonster(x, y);
                    monsters.add(monster);
                }
                if (line.charAt(x) == 'F') {
                    Monster monster = new FollowerMonster(x, y);
                    monsters.add(monster);
                }
            }
        }
        return monsters;
    }
    @Override
    protected Steven createSteven() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Steven(x, y);
        }
        return null;
    }


}
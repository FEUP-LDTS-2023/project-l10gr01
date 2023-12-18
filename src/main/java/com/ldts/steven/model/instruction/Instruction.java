package com.ldts.steven.model.instruction;

import java.util.Arrays;
import java.util.List;

public class Instruction {

    private final List<String> entries;

    public Instruction() {
        this.entries = Arrays.asList(
                "In this game, you are Steven Universe,",
                "a half human half gem boy who had your",
                "friends captured by monsters. In order",
                "to win the game, you must go through a",
                "maze and DEFEAT ALL THE MONSTERS!",
                "You can choose between 3 different",
                "levels, each one in increased difficulty.",
                "Characters: ",
                "M -> Normal Monster",
                "M -> Follower Monster",
                "S -> Steven",
                "@ -> Life",
                "X -> Upgraded Bomb",
                "U -> Unlimited Bomb Upgrade",
                "",
                "Note: if you want to stop the game in the middle of the level, press Q.",
                "",
                "Exit"
        );
    }


    public String getEntry(int i) {
        return entries.get(i);
    }


    public int getNumberEntries() {
        return this.entries.size();
    }
}

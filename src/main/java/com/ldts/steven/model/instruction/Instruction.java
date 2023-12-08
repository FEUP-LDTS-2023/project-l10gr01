package com.ldts.steven.model.instruction;

import java.util.Arrays;
import java.util.List;

public class Instruction {

    private final List<String> entries;
    private int currentEntry = 0;

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
                "Exit"
        );
    }


    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}

package com.ldts.steven.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private final List<String> entries2;
    private int currentEntry = 0;

    public Menu() {
        this.entries2 = List.of(
                "Start");

        this.entries = Arrays.asList(
                "Start",
                "",
                "Instructions" ,
                "",
                "Exit");
    }

    public void nextEntry() {
        currentEntry++;
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(4);
    }

    public boolean isSelectedInstruction(){ return isSelected(2);}
    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}

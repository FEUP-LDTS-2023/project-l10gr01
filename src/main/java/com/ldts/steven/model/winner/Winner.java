package com.ldts.steven.model.winner;
import java.util.Arrays;
import java.util.List;

public class Winner {

    private final List<String> entries;
    private int currentEntry = 0;

    public Winner() {
        this.entries = Arrays.asList(
                "YOU WIN !!!!!!!",
                "-----------------------------",
                "-----------------------------",
                "-----------------------------",
                "-----------------------------",
                "-----------------------------",
                "-----------------------------",
                "-----------------------------",
                "-----------------------------",
                "Exit"
        );
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
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
        return isSelected(15);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
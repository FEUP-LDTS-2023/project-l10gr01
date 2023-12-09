package com.ldts.steven.model.selectLevel;

import java.util.Arrays;
import java.util.List;

public class SelectLevel {

    private final List<String> entries;
    private int currentEntry = 0;

    public SelectLevel() {

        this.entries = Arrays.asList(
                "LEVEL 1",
                "",
                "LEVEL 2" ,
                "",
                "LEVEL 3",
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
        return isSelected(6);
    }

    public boolean isSelectedLevelOne(){ return isSelected(0);}
    public boolean isSelectedLevelTwo() {
        return isSelected(2);
    }
    public boolean isSelectedLevelThree() {
        return isSelected(4);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }

}

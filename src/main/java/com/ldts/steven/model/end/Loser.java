package com.ldts.steven.model.end;
import java.util.Arrays;
import java.util.List;

public class Loser extends End{

    private final List<String> entries;


    public Loser() {
        this.entries = Arrays.asList(
                "   ___   _   __  __ ___ ",
                "  / __| /_\\ |  \\/  | __|",
                " | (_ |/ _ \\| |\\/| | _| ",
                "  \\___/_/ \\_\\_|_ |_|___|",
                "  / _ \\ \\ / / __| _ \\   ",
                " | (_) \\ V /| _||   /   ",
                "  \\___/ \\_/ |___|_|_\\   ",
                "",
                "",
                "",
                "",
                "           Exit    "
        );
        super.win=false;
    }


    @Override
    public String getEntry(int i) {
        return entries.get(i);
    }


    @Override
    public int getNumberEntries() {
        return this.entries.size();
    }
}
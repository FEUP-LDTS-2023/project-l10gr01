package com.ldts.steven.model.end;
import java.util.Arrays;
import java.util.List;

public class Winner extends End{

    private final List<String> entries;


    public Winner() {
        this.entries = Arrays.asList(
                " __   _____  _   _      ",
                " \\ \\ / / _ \\| | | |     ",
                "  \\ V / (_) | |_| |     ",
                " __|_| \\___/_\\___/_   _ ",
                " \\ \\    / /_ _| \\| | | |\n",
                "  \\ \\/\\/ / | || .` | |_|\n",
                "   \\_/\\_/ |___|_|\\_| (_)\n",
                "",
                "",
                "",
                "",
                "           Exit    "
        );
        super.win=true;
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

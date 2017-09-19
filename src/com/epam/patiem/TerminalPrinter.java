package com.epam.patiem;

import java.util.List;

public class TerminalPrinter {

    private String defaultPrompt;

    public void setDefoultPrompt(String defaultPrompt) {
        this.defaultPrompt = defaultPrompt;
    }

    public TerminalPrinter() {
        this.defaultPrompt = "$>";
    }

    public String getDefoultPrompt() {
        return defaultPrompt;
    }

    public void printPrompt() {
        System.out.print(defaultPrompt);
    }

    public void printList(List<String> list) {

        for (String name : list)
            System.out.println(name);
    }
}

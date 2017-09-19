package com.epam.patiem;

import java.util.List;

public class TerminalPrinter {

    private final String defaultPrompt = "$>";
    private String customPropt;


    public void setCustomPrompt(String newPrompt) {
        customPropt = newPrompt + ">";
    }

    public void setPromptToDefault() {
        customPropt = defaultPrompt;
    }

    public TerminalPrinter() {
        customPropt = "$>";
    }

    public void printPrompt() {
        System.out.print(customPropt);
    }

    public void printList(List<String> list) {

        for (String name : list)
            System.out.println(name);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void setPrompt(String command) {
        String newPropmt = command.split(" ")[1];
        if (newPropmt.equals("reset")) setPromptToDefault();
        else if (newPropmt.equals("$cwd")) getCurrentDir();
        else setCustomPrompt(newPropmt);
    }

    public Object getCurrentDir() {
        return new Object();
    }
}

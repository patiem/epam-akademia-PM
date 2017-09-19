package com.epam.patiem;

import java.util.List;

public class TerminalPrinter {

    private final String defaultPrompt = "$>";
    private String customPropt;
    private String cwdPrompt;
    private boolean isCwd;


    public void setCwd(boolean cwd) {
        isCwd = cwd;
    }

    public void setCwdPrompt(String cwdPrompt) {
        this.cwdPrompt = cwdPrompt;
        if (isCwd) setCustomPrompt(cwdPrompt);
        System.out.println(customPropt);

    }


    public void setCustomPrompt(String newPrompt) {
        customPropt = newPrompt + ">";

    }

    public void setPromptToDefault() {
        customPropt = defaultPrompt;
    }

    public TerminalPrinter(String cwdPrompt) {
        customPropt = "$>";
        this.cwdPrompt = cwdPrompt;
        isCwd = false;
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

    public void setPrompt(String newPropmt) {
        if (newPropmt.equals("reset")) {
            setPromptToDefault();
        }
        else if (newPropmt.equals("$cwd")) {
            isCwd = true;
            setCwdPrompt(newPropmt);
        }
        else {
            setCustomPrompt(newPropmt);
        }
    }

}

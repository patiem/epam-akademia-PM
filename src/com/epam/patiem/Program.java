package com.epam.patiem;

import java.util.Scanner;

public class Program {

    Scanner scanner;
    Boolean running;
    CurrentDirectory currentDirectory;
    TerminalPrinter printer;
    MenageStatistics stats;


    public Program(Scanner scanner, TerminalPrinter printer, MenageStatistics statistics) {
        this.scanner = scanner;
        running = true;
        currentDirectory = new CurrentDirectory();
        stats = statistics;
        this.printer = printer;

    }


    public void run() {

        String command;

        while (running) {

            printer.printPrompt();
            command = scanner.nextLine();

            switch (command.split(" ")[0]) {

                case "dir":
                    printer.printList(currentDirectory.showFilesInDirectory());
                    break;

                case "cd":
                    currentDirectory.changeDirectory(command);
                    break;

                case "exit":
                    running = false;
                    break;

                case "prompt" :
                    checkPromptOptions(command);
                    break;

                case "tree" :
                    printer.printMessage("Sorry :D");
                    break;

                case "statistics" :
                    printer.printMessage("Sorry :D");
                    break;

                default:
                    printer.printMessage("Wrong command");

            }
        }
    }

    private void checkPromptOptions(String command) {
        if (command.split(" ")[1].equals("$cwd")) printer.
        setPrompt(currentDirectory.getCurrentPath());
            else printer.setPrompt(command.split(" ")[1]);
    }
}


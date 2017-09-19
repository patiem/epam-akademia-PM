package com.epam.patiem;

import java.util.Scanner;

public class Program {

    Scanner scanner;
    Boolean running;
    CurrentDirectory currentDirectory;
    TerminalPrinter printer;


    public Program(Scanner scanner, TerminalPrinter printer) {
        this.scanner = scanner;
        running = true;
        currentDirectory = new CurrentDirectory();
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
                    printer.setPrompt(command);
                    break;

                default:
                    printer.printMessage("Wrong command");

            }
        }
    }
}


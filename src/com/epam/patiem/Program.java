package com.epam.patiem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {

    Scanner scanner;
    Boolean running;
    CurrentDirectory currentDirectory;



    String prompt = "$>";

    public Program(Scanner scanner) {
        this.scanner = scanner;
        running = true;
        currentDirectory = new CurrentDirectory();
    }


    public void run() {

        String command;

        while (running) {

            System.out.print(prompt);
            command = scanner.nextLine();

            switch (command.split(" ")[0]) {

                case "dir":
                    currentDirectory.showFilesInDirectory();
                    break;

                case "cd":
                    currentDirectory.changeDirectory(command);
                    break;

                case "exit":
                    running = false;
                    break;

            }
        }
    }
}


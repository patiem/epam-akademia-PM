package com.epam.patiem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {

    Scanner scanner;
    Boolean running;
    String prompt = "$>";

    public Program(Scanner scanner) {
        this.scanner = scanner;
        running = true;
    }


    public void run() {

        String command;

        while(running) {

            System.out.print(prompt);
            command = scanner.nextLine();

            switch (command) {

                case "dir":
                    showFilesInDirectory();
                    break;

                case "exit":
                    running = false;
                    break;

            }

            //running = false;

        }
    }

    private void showFilesInDirectory() {


        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        File file = new File(s);
        File[] allFiles = file.listFiles();

        String prefix;
        boolean isFile;

        for (File f : allFiles) {
            isFile = f.isFile();
            prefix = isFile ? "FILE  ":"DIR  ";
            System.out.println(prefix + f.getName());
        }
    }
}

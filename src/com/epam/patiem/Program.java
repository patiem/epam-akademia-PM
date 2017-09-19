package com.epam.patiem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {

    Scanner scanner;
    Boolean running;
    Path startPath;
    File currentFile;
    String prompt = "$>";

    public Program(Scanner scanner) {
        this.scanner = scanner;
        running = true;
        startPath = Paths.get("");
        //String s = startPath.toAbsolutePath().toString();
        currentFile = new File(startPath.toAbsolutePath().toString());
    }


    public void run() {

        String command;

        while(running) {

            System.out.print(prompt);
            command = scanner.nextLine();

            switch (command.split(" ")[0]) {

                case "dir":
                    showFilesInDirectory();
                    break;

                case "cd":
                    changeDirectory(command);
                    break;

                case "exit":
                    running = false;
                    break;

            }

            //running = false;

        }
    }

    private void changeDirectory(String command) {

        String dirName = command.split(" ")[1];

        if (dirName.equals("..")) {
            currentFile = currentFile.getParentFile();
        }
    }

    private void showFilesInDirectory() {


        //Path currentRelativePath = Paths.get("");
//        String s = currentPath.toAbsolutePath().toString();
//        File file = new File(s);
        File[] allFiles = currentFile.listFiles();

        String prefix;
        boolean isFile;

        for (File f : allFiles) {
            isFile = f.isFile();
            prefix = isFile ? "FILE ":"DIR  ";
            System.out.println(prefix + f.getName());
        }
    }
}

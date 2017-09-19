package com.epam.patiem;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CurrentDirectory {

    Path startPath;
    File currentFile;
    Path currentPath;

    public CurrentDirectory() {

        startPath = Paths.get("");
        currentPath = Paths.get("");
        //String s = startPath.toAbsolutePath().toString();
        currentFile = new File(startPath.toAbsolutePath().toString());
    }

    protected void changeDirectory(String command) {

        String dirName = command.split(" ")[1];
        try {
            if (dirName.equals("..") ) {

                currentFile = currentFile.getParentFile();
            } else {
                Path newDir = Paths.get(dirName);
                File changeToDir = new File(newDir.toAbsolutePath().toString());
                if (changeToDir.exists()) {
                    currentFile = new File(newDir.toAbsolutePath().toString());
                } else {
                    throw new NullPointerException("No such directory");
                }
            }
        } catch (NullPointerException e) {

            System.out.println(e.getMessage());
        }
    }

    protected void showFilesInDirectory() {

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


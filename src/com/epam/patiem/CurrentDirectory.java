package com.epam.patiem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CurrentDirectory {

    Path startPath;
    File currentFile;
    Path currentPath;

    public CurrentDirectory() {

        startPath = Paths.get("");
        currentPath = Paths.get("");
        currentFile = new File(startPath.toAbsolutePath().toString());
    }

    protected void changeDirectory(String command) {

        String dirName = command.split(" ")[1];
        try {
            if (dirName.equals("..") ) {
                currentFile = currentFile.getParentFile();
            } else {
                String fileName = currentFile.getAbsolutePath() + "/" + dirName;
                Path newDir = Paths.get(fileName);
                File changeToDir = new File(newDir.toAbsolutePath().toString());
                if (changeToDir.exists()) {
                    currentFile = changeToDir;
                } else {
                    throw new IOException("No such directory");
                }
            }
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    protected List<String> showFilesInDirectory() {

        File[] allFiles = currentFile.listFiles();
        return makeStrings(allFiles);
    }

    private List<String> makeStrings(File[] allFiles) {

        String prefix;
        boolean isFile;
        List<String> fileNames = new ArrayList<>();

        for (File f : allFiles) {
            isFile = f.isFile();
            prefix = isFile ? "FILE ":"DIR  ";
            fileNames.add(prefix + f.getName());
        }

        return fileNames;
    }

    public String getCurrentPath() {
        return currentFile.getPath();
    }
}


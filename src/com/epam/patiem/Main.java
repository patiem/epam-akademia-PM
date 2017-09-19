package com.epam.patiem;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Path currentPath = Paths.get("");
        System.out.println(currentPath.toAbsolutePath());

        Scanner scanner = new Scanner(System.in);
        TerminalPrinter printer = new TerminalPrinter(currentPath.toAbsolutePath().toString());
        MenageStatistics stats = new CommandStatistics();
        Program pr = new Program(scanner, printer, stats);
        pr.run();
    }
}

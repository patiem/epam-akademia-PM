package com.epam.patiem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TerminalPrinter printer = new TerminalPrinter();
        MenageStatistics stats = new CommandStatistics();
        Program pr = new Program(scanner, printer, stats);
        pr.run();
    }
}

package com.epam.patiem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Program pr = new Program(scanner);
        pr.run();
    }
}

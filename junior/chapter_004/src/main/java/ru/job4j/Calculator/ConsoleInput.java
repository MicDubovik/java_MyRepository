package ru.job4j.Calculator;

import java.util.Scanner;

public class ConsoleInput implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String askOperation() {
        System.out.println("Enter operation");
        return scanner.nextLine();
    }


    @Override
    public int askNumber() {
        System.out.println("Enter number :");
        return scanner.nextInt();

    }
}


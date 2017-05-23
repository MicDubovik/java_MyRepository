package ru.job4j.Calculator;

import java.util.Scanner;

/**
 * ConsoleInput.
 */
public class ConsoleInput implements Input {
    /**
     * Input.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * askOperation.
     * @return
     */
    @Override
    public String askOperation() {
        System.out.println("Enter operation");
        return scanner.nextLine();
    }

    /**
     * askNumber.
     * @return
     */
    @Override
    public int askNumber() {
        System.out.println("Enter number :");
        return scanner.nextInt();

    }
}


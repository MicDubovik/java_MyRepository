package ru.job4j.Calculator;

/**
 * SecondMenu.
 */
public class SecondMenu implements IMenu {
    /**
     * menuShow.
     */
    public void menuShow() {
        System.out.println("========================");
        System.out.println("---EngineerCalculator---");
    }

    /**
     * showOperation.
     */
    @Override
    public void showOperation() {
        System.out.println("Enter operation: sin , cos ");
    }
}

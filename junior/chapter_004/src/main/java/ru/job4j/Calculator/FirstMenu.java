package ru.job4j.Calculator;

/**
 * FirstMenu.
 */
public class FirstMenu implements IMenu {
    /**
     * menuShow.
     */
    public void menuShow() {
        System.out.println("========================");
        System.out.println("--------Calculator------");
    }

    /**
     * showOperation.
     */
    @Override
    public void showOperation() {
        System.out.println("Enter operation *,/,+,- ");
    }
}

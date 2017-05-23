package ru.job4j.Calculator;

/**
 * InteractCalculator.
 */
public class InteractCalc {
    /**
     * MenuCalc
     */
    MenuCalc menuCalc;

    /**
     * Main.
     *
     * @param args
     */
    public static void main(String[] args) {

        MenuCalc menuCalc = new MenuCalc(2);
        menuCalc.menuShow();
        do {
            menuCalc.showOperation();
            menuCalc.start();
            menuCalc.result();
            System.out.println("Exit ? ... y/n ");
        } while (!menuCalc.again().equals("y"));

    }

}

package ru.job4j.Calculator;

import java.util.Scanner;

/**
 * MenuCalculator.
 */
public class MenuCalc {
    /**
     * Calculator.
     */
    Calculator calculator;
    /**
     * Scanner.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * numOperation.
     */
    private String numOperation;
    /**
     * ConsoleInput.
     */
    ConsoleInput consoleIn;
    /**
     * Imenu.
     */
    IMenu imenu;
    /**
     * Istart.
     */
    IStart istart;

    /**
     * MenuCalc.
     * @param num
     */
    public MenuCalc( int num) {
        if (num==1){
            this.imenu = (IMenu) new SecondMenu();
            this.istart = (IStart) new EngineerStart();
        } else {
            this.imenu = (IMenu) new FirstMenu();
            this.istart = (IStart) new SimpleStart();
        }

    }

    /**
     * menuShow.
     */
    public void menuShow() {
//        this.imenu = (IMenu) new SecondMenu();
        this.imenu.menuShow();
    }


    /**
     * start.
     */
    public void start() {

//        this.istart = (IStart) new EngineerStart();
        istart.start();

    }

    /**
     * showOperation.
     */
    public void showOperation() {
//        this.imenu = new SecondMenu();
        this.imenu.showOperation();
    }

    /**
     * result.
     */
    public void result() {

        System.out.println(istart.getResult());
    }

    /**
     * again.
     * @return
     */
    public String again() {

        return scanner.next();
    }

}

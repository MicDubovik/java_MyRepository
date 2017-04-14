package ru.job4j.Calculator;

import java.util.Scanner;

public class MenuCalc {

    Calculator calculator;
    Scanner scanner = new Scanner(System.in);
    private String numOperation;
    ConsoleInput consoleIn;
    IMenu imenu;
    IStart istart;

    public MenuCalc( int num) {
        if (num==1){
            this.imenu = (IMenu) new SecondMenu();
            this.istart = (IStart) new EngineerStart();
        } else {
            this.imenu = (IMenu) new FirstMenu();
            this.istart = (IStart) new SimpleStart();
        }

    }

    public void menuShow() {
//        this.imenu = (IMenu) new SecondMenu();
        this.imenu.menuShow();
    }




    public void start() {

//        this.istart = (IStart) new EngineerStart();
        istart.start();

    }

    public void showOperation() {
//        this.imenu = new SecondMenu();
        this.imenu.showOperation();
    }


    public void result() {

        System.out.println(istart.getResult());
    }

    public String again() {

        return scanner.next();
    }

}

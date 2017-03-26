package ru.job4j.Calculator;

public class InteractCalc {

    MenuCalc menuCalc;


    public static void main(String[] args) {


        MenuCalc menuCalc = new MenuCalc();
        menuCalc.menuShow();
        do {
            menuCalc.showOperation();
            menuCalc.start();
            menuCalc.result();
            System.out.println("Exit ? ... y/n ");
        } while (!menuCalc.again().equals("y"));

    }

}

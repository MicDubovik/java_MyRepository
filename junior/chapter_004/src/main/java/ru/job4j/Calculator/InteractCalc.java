package ru.job4j.Calculator;

public class InteractCalc {

    MenuCalc menuCalc;

    public static void main(String[] args) {

            System.out.println("========================");
            System.out.println("--------Calculator------");


         MenuCalc menuCalc = new MenuCalc();
        do {
            System.out.println("Enter operation *,/,+,- ");
            menuCalc.start();
            menuCalc.result();
            System.out.println("Exit ? ... y/n ");
        } while (!menuCalc.again().equals("y"));

    }

}

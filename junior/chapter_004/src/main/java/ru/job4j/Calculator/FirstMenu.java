package ru.job4j.Calculator;

public class FirstMenu implements IMenu {

    public void menuShow() {
        System.out.println("========================");
        System.out.println("--------Calculator------");
    }

    @Override
    public void showOperation() {
        System.out.println("Enter operation *,/,+,- ");
    }
}

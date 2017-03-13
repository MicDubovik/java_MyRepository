package ru.job4j.Calculator;

public class SecondMenu implements IMenu{
    public void menuShow(){
        System.out.println("========================");
        System.out.println("---EngineerCalculator---");
    }

    @Override
    public void showOperation() {
        System.out.println("Enter operation: sin , cos ");
    }
}

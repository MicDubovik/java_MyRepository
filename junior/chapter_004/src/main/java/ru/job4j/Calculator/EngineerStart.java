package ru.job4j.Calculator;

public class EngineerStart implements IStart {

    EngineerCalc calculator;
    private String numOperation;
    ConsoleInput consoleIn = new ConsoleInput();

    public void start() {

        calculator = new EngineerCalc();
        numOperation = consoleIn.askOperation();
        switch (numOperation) {
            case "sin":
                calculator.sinus(consoleIn.askNumber(), consoleIn.askNumber());
                break;
            case "cos":
                calculator.cosinus(consoleIn.askNumber(), consoleIn.askNumber());

                break;
            default:
                System.out.println("The operation is not");
        }
    }

    public double getResult() {
        return this.calculator.getResult();
    }
}

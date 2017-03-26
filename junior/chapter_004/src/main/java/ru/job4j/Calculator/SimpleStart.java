package ru.job4j.Calculator;

public class SimpleStart implements IStart {
    Calculator calculator = new Calculator();
    private String numOperation;
    ConsoleInput consoleIn = new ConsoleInput();

    public void start() {


        numOperation = consoleIn.askOperation();
        switch (numOperation) {
            case "/":
                calculator.div(consoleIn.askNumber(), consoleIn.askNumber());
                ;
                break;
            case "*":
                calculator.mul(consoleIn.askNumber(), consoleIn.askNumber());
                calculator.getResult();
                break;
            case "+":
                calculator.add(consoleIn.askNumber(), consoleIn.askNumber());
                calculator.getResult();
                break;
            case "-":
                calculator.sub(consoleIn.askNumber(), consoleIn.askNumber());
                calculator.getResult();
                break;

        }

    }

    public double getResult() {
        return this.calculator.getResult();
    }
}

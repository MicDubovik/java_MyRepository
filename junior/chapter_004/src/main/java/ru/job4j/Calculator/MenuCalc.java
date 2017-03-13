package ru.job4j.Calculator;

import java.util.Scanner;

public class MenuCalc {
    Calculator calculator;
    Scanner scanner = new Scanner(System.in);
    private String numOperation;
    ConsoleInput consoleIn ;


    public void start(){
        consoleIn = new ConsoleInput();
        calculator = new Calculator();
        numOperation = consoleIn.askOperation();
        switch (numOperation){
            case "/" :calculator.div(consoleIn.askNumber(),consoleIn.askNumber());
            ;break;
            case "*" : calculator.mul(consoleIn.askNumber(),consoleIn.askNumber());
                calculator.getResult();break;
            case "+" : calculator.add(consoleIn.askNumber(),consoleIn.askNumber());
                calculator.getResult();break;
            case "-" : calculator.sub(consoleIn.askNumber(),consoleIn.askNumber());
                calculator.getResult();break;

        }

    }
    public void   result(){

        System.out.println(calculator.getResult());
    }
    public String  again(){

        return scanner.next();
    }

}

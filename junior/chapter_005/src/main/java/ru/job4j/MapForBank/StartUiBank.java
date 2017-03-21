package ru.job4j.MapForBank;

import java.util.HashMap;

public class StartUiBank {

    private InputBank input;
    private HashMap<Integer, UserActionBank> number;
    Bank bank;
    MenuBank menu;

    public StartUiBank(InputBank input) {
        this.input = input;
    }

    public StartUiBank(InputBank input, Bank bank) {
        this.input = input;
        this.bank = bank;
    }

    public void init() {
        menu = new MenuBank(input, bank);
        number = menu.fillActions();


        System.out.println("*****************************");
        System.out.println("* Программа перевода денег  *");
        System.out.println("*****************************");

        do {
            menu.show();
            menu.select(input.ask("select: ", number));
        } while (!"y".equals(this.input.ask("Exit ?(y/n):")));
    }


    public static void main(String[] args) {
       User  user = new User();
        Bank bank = new Bank();
        InputBank input = new ValidateInput();
        new StartUiBank(input,bank).init();
    }
}



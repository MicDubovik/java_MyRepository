package ru.job4j.MapForBank;

import java.util.HashMap;

/**
 * StartUiBank.
 */
public class StartUiBank {
    /**
     * InputBank
     */
    private InputBank input;
    /**
     * HashMap<Integer, UserActionBank>.
     */
    private HashMap<Integer, UserActionBank> number;
    /**
     * Bank
     */
    Bank bank;
    /**
     * MenuBank.
     */
    MenuBank menu;

    /**
     * Constructor.
     * @param input
     */
    public StartUiBank(InputBank input) {
        this.input = input;
    }

    /**
     * Constructor.
     * @param input
     * @param bank
     */
    public StartUiBank(InputBank input, Bank bank) {
        this.input = input;
        this.bank = bank;
    }

    /**
     * Init.
     */
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

    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {
       User  user = new User();
        Bank bank = new Bank();
        InputBank input = new ValidateInput();
        new StartUiBank(input,bank).init();
    }
}



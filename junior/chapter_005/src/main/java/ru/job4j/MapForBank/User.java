package ru.job4j.MapForBank;

import java.util.ArrayList;
import java.util.List;

/**
 * Class User.
 */

public class User {

    private String name;
    private String passport;
    List<Account> accounts = new ArrayList<>();

    public User(String name, String passport, List<Account> accounts) {
        this.name = name;
        this.passport = passport;
        this.accounts = accounts;
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public User(String passport) {
        this.passport = passport;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public List<Account> getAccounts() {

        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void showUser() {
        if (this.accounts != null) {
            System.out.println("User name: " + this.getName() + " ,user have " + this.getAccounts().size() + " account :");

            int i = 0;
            for (Account account : accounts) {
                System.out.println("Account №" + (i + 1) + ". Requisites:" + account.getRequisites() + " ,Value:" + account.getValue());
                i++;

            }
        } else {
            System.out.println("User " + this.getName() + " don't have account ");
        }
//
    }
}
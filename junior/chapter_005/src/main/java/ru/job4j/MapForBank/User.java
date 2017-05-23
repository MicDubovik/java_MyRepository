package ru.job4j.MapForBank;

import java.util.ArrayList;
import java.util.List;

/**
 * Class User.
 */

public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * passport.
     */
    private String passport;
    /**
     * List<Account>.
     */
    List<Account> accounts = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param name
     * @param passport
     * @param accounts
     */
    public User(String name, String passport, List<Account> accounts) {
        this.name = name;
        this.passport = passport;
        this.accounts = accounts;
    }

    /**
     * Constructor.
     *
     * @param name
     * @param passport
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Constructor.
     *
     * @param passport
     */
    public User(String passport) {
        this.passport = passport;
    }

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Get.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get.
     *
     * @return
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Set.
     *
     * @param passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Get.
     *
     * @return
     */
    public List<Account> getAccounts() {

        return accounts;
    }

    /**
     * Set.
     *
     * @param accounts
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Show user.
     */
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

    }
}
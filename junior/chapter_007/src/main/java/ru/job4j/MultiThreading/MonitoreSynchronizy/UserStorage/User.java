package ru.job4j.MultiThreading.MonitoreSynchronizy.UserStorage;

public class User {
    /**
     * Field amount.
     */
    private int amount;
    /**
     * Field id.
     */
    private int id;

    /**
     * Constructor.
     * @param amount
     */
    public User(int amount) {
        this.amount = amount;
        this.id++;
    }

    /**
     * Get amount.
     * @return
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Add money to user.
     * @param value
     */
    public void addMoney(int value) {
          synchronized (this) {
            this.amount += value;
          }
    }

    /**
     * Subtraction money from user.
     * @param value
     */
    public void devMoney(int value) {
        synchronized (this) {
            this.amount -= value;
        }
     }
}



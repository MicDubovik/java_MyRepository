package ru.job4j.MultiThreading.MonitoreSynchronizy.UserStorage;

public class User {

    private int amount;

    private int id;

    public User(int amount) {
        this.amount = amount;
        this.id++;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount >= 0) {
            this.amount = amount;
        }
    }

    public void addMoney(int value) {
          synchronized (this) {
            this.amount += value;
          }
    }

    public void devMoney(int value) {
        synchronized (this) {
            this.amount -= value;
        }
     }
}



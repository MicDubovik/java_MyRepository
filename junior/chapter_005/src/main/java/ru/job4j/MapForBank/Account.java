package ru.job4j.MapForBank;

/**
 * Class Account.
 *
 */
public class Account {

    private int value;
    private int requisites;

    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public Account(int requisites) {
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRequisites() {
        return requisites;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }


}

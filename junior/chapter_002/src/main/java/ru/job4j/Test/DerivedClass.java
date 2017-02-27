package ru.job4j.Test;

/**
 * Created by Katy on 27.02.2017.
 */
public class DerivedClass extends BaseClass{

    private String number_derived = "Derived";

    public String getNumber_derived() {
        return number_derived;
    }

    public void setNumber_derived(String number_derived) {
        this.number_derived = number_derived;
    }


    public DerivedClass( ) {

    }

    public void write() {
        System.out.println("This is Derived method");
    }
}

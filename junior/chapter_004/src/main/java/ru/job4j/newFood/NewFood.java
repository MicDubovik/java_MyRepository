package ru.job4j.newFood;

public class NewFood extends Food {

    protected boolean canReproduct ;

    public NewFood(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    public NewFood(String name, String expiryDate, String createDate, int price, int disscount, boolean canReproduct) {
        super(name, expiryDate, createDate, price, disscount);
        this.canReproduct = canReproduct;
    }

}

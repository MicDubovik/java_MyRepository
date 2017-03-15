package ru.job4j.newFood;

public class Food {
    protected   String name;
    protected String expiryDate  ;
    protected String createDate; // "dd.MM.yyyy"

    protected int price;
    protected int disscount;

    public Food() {
    }

    public Food(String name, String expiryDate, String createDate, int price, int disscount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;

        this.price = price;
        this.disscount = disscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDisscount() {
        return disscount;
    }

    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }
}

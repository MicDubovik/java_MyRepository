package ru.job4j.Food;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Food ;
 */

public class Food {
    private  String name;
    private int expiryDate  ;
    private String createDate;

    private int price;
    private int disscount;

    public Food() {
    }

    public Food(String name, int expiryDate, String createDate, int price, int disscount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;

        this.price = price;
        this.disscount = disscount;
    }

    /**
     * Count % use product after day create.
     * @return
     * @throws ParseException
     */

    public int countDays() throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Date dateCreate = null;
        Date nowDate = new Date();
        String dateNow = format.format(nowDate);

        try {

            dateCreate = format.parse(this.createDate);
            nowDate = format.parse(dateNow);

        } catch (Exception e) {
            e.printStackTrace();
        }


        long difference = nowDate.getTime() - dateCreate.getTime();

        int daysNowSubCreate = (int) (difference / (24 * 60 * 60 * 1000));

        int percent = 100 * (this.expiryDate - daysNowSubCreate)/this.expiryDate;


        return percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
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

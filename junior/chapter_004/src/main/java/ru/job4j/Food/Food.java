package ru.job4j.Food;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Food ;
 */

public class Food {
    /**
     * Name.
     */
    private  String name;
    /**
     * expiryDate.
     */
    private int expiryDate  ;
    /**
     * createDate.
     */
    private String createDate; // "dd.MM.yyyy"
    /**
     * price.
     */
    private int price;
    /**
     * disscount.
     */
    private int disscount;

    /**
     * Constructor.
     */
    public Food() {
    }

    /**
     * Constructor.
     * @param name
     * @param expiryDate
     * @param createDate
     * @param price
     * @param disscount
     */
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

    /**
     * Get.
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get.
     * @return
     */
    public int getExpiryDate() {
        return expiryDate;
    }

    /**
     * Set.
     * @param expiryDate
     */
    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }
    /**
     * Get.
     * @return
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Set.
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    /**
     * Get.
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set.
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Get.
     * @return
     */
    public int getDisscount() {
        return disscount;
    }

    /**
     * Set.
     * @param disscount
     */
    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }
}

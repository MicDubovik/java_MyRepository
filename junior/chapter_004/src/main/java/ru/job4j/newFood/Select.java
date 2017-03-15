package ru.job4j.newFood;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Select implements SelectProduct {

    public int countDays(Food food) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Date dateCreate = null;
        Date nowDate = new Date();
        Date dateExp = null;
        String dateNow = format.format(nowDate);

        try {

            dateCreate = format.parse(food.createDate);
            dateExp = format.parse(food.expiryDate);
            nowDate = format.parse(dateNow);

        } catch (Exception e) {
            e.printStackTrace();
        }
        long dNowSubCr = nowDate.getTime() - dateCreate.getTime();

        int daysNowSubCreate = (int) (dNowSubCr / (24 * 60 * 60 * 1000));

        long dExpSubCreate = dateExp.getTime() - dateCreate.getTime();

        int daysExpSubCreate = (int) (dExpSubCreate / (24 * 60 * 60 * 1000));

        int percent = 100 * (daysNowSubCreate)/daysExpSubCreate;




        return percent;
    }
}

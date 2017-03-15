package ru.job4j.newFood;

import java.text.ParseException;

public class Start {
    public static void main(String[] args) throws ParseException {

        Food food = new Food("Milk", "20.03.2017", "10.03.2017", 100, 0);
        NewFood food2 =   new NewFood("Beer", "14.03.2017", "10.03.2017", 100, 0,true);
        NewFood food3 =   new NewFood("Cola", "16.03.2017", "10.03.2017", 100, 0,true);


        ControllQuality cq = new ControllQuality(new Strategy().selectStrategyMethod(food));
        ControllQuality cq2 = new ControllQuality(new Strategy().newSelectStrategyMethod(food2));
        ControllQuality cq3 = new ControllQuality(new Strategy().newSelectStrategyMethod(food3));

        cq.strategyMethod(food);

        cq2.strategyMethod(food2);

        cq3.strategyMethod(food3);

        Select select = new Select();
        Shop shop= new Shop();

        System.out.println( select.countDays(food));
        System.out.println( select.countDays(food2));
        System.out.println( select.countDays(food3));
//        shop.getShopProducts();
//        for (Food arg : shop.getShopProducts()) {
//
//                System.out.print(arg.getName());
//
//            System.out.println();
//
//        }

    }
}

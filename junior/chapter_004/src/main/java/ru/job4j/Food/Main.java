package ru.job4j.Food;

import java.text.ParseException;

/**
 * Main.
 */
public class Main {

    /**
     * Method to select strategy from counter use product.
     * @param food
     * @return
     * @throws ParseException
     */

    public IStrategy selectStrategyMethod(Food food) throws ParseException {
        IStrategy strategy = null;

        if (food.countDays() < 25  ) {

            strategy = new Warehouse();
        } else if (25 < food.countDays() && food.countDays() < 75) {
             strategy = new Shop();
        } else if (food.countDays() > 75 && food.countDays() < 100 ) {
              strategy = new ShopDisscount();

        } else {

            strategy = new Trash();
        }
        return strategy;
    }

    /**
     * method main.
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {

        Food food = new Food("Milk", 5, "10.03.2017", 100, 0);


        ControllQuality cq = new ControllQuality(new Main().selectStrategyMethod(food));

        cq.strategyMethod(food);



    }

}



package ru.job4j.newFood;

import java.text.ParseException;

/**
 * Strategy.
 */
public class Strategy {
    /**
     * selectStrategyMethod.
     * @param food
     * @return
     * @throws ParseException
     */
    public IStorage selectStrategyMethod(Food food) throws ParseException {
        IStorage storage = null;
        Select select = new Select();
       int percent = select.countDays(food);

        if (percent < 25 && percent>=0 ) {
            storage = new WareHouse( );
        } else if (25 < percent && percent < 75) {
            storage = new Shop( );
        } else if (percent > 75 && percent < 100 ) {
            storage = new Shop( );

        } else {

            storage = new Trash( );
        }
        return storage;
    }

    /**
     * newSelectStrategyMethod.
     * @param food
     * @return
     * @throws ParseException
     */
    public IStorage newSelectStrategyMethod(Food food) throws ParseException {
        IStorage storage = null;
        Select select = new Select();
        int percent = select.countDays(food);

        if (percent < 25) {
            storage = new WareHouse2();
        } else if (25 < percent && percent < 75) {
            storage = new Shop();
        } else if (percent > 75 && percent < 100) {
            storage = new AbstractShop(new ShopDisscount(new Shop()));

        } else {
            if (((NewFood) food).canReproduct == true) {
                storage = new Refregerator();
            } else {
                storage = new Trash();
            }

        }
        return storage;
    }
}

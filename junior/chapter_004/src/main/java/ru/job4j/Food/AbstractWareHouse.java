package ru.job4j.Food;

/**
 * AbstractWareHouse
 */
public abstract class AbstractWareHouse implements IStrategy {
    /**
     * IAddWarehouse.
     */
    protected IAddWarehouse iAddWarehouse;

    /**
     * Constructor.
     * @param iAddWarehouse
     */
    public AbstractWareHouse(IAddWarehouse iAddWarehouse) {
        this.iAddWarehouse = iAddWarehouse;
    }

    /**
     * Addfood.
     * @param food
     * @return
     */
    public Food[] addFood(Food food) {

        return iAddWarehouse.addFood(food);
    }
}

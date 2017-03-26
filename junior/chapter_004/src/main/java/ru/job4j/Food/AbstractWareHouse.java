package ru.job4j.Food;

public abstract class AbstractWareHouse implements IStrategy {

    protected IAddWarehouse iAddWarehouse;

    public AbstractWareHouse(IAddWarehouse iAddWarehouse) {
        this.iAddWarehouse = iAddWarehouse;
    }

    public Food[] addFood(Food food) {

        return iAddWarehouse.addFood(food);
    }
}

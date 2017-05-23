package ru.job4j.newFood;

/**
 * Interface for keeping products
 */
public interface IStorage {
    /**
     * addFood
     * @param food
     * @return
     */
    Food[] addFood(Food food);

    /**
     * removeProduct.
     * @param food
     * @return
     */
    Food[] removeProduct(Food food);


}

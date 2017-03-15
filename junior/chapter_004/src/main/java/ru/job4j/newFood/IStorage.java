package ru.job4j.newFood;

/**
 * Interface for keeping products
 */
public interface IStorage {

    Food[] addFood(Food food);

    Food[] removeProduct(Food food);


}

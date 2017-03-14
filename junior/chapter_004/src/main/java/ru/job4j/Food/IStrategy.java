package ru.job4j.Food;

public interface IStrategy {

    /**
     * Interface to select strategy.
     * @param food
     * @return
     */
    Food[] addFood(Food food);
}

package ru.job4j.Food;

public abstract class AbstractTrash {
    IStrategy strategy;

    public AbstractTrash(IStrategy strategy) {
        this.strategy = strategy;
    }

    public Food[] addFood(Food food) {
        return strategy.addFood(food);
    }
}

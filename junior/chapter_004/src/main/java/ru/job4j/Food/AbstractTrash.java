package ru.job4j.Food;

/**
 * AbstractTrash
 */
public abstract class AbstractTrash {
    /**
     * IStrategy.
     */
    IStrategy strategy;

    /**
     * Constructor.
     * @param strategy
     */
    public AbstractTrash(IStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * AddFood.
     * @param food
     * @return
     */
    public Food[] addFood(Food food) {
        return strategy.addFood(food);
    }
}

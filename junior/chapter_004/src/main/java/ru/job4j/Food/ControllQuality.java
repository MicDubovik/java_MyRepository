package ru.job4j.Food;

/**
 * ControllQuality
 */
public class ControllQuality {
    /**
     * IStrategy.
     */
    private IStrategy strategy;

    /**
     * Constructor.
     * @param strategy
     */
    public ControllQuality(IStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * strategyMethod.
     * @param food
     */
    public void strategyMethod(Food food){
        strategy.addFood( food);
    }

}

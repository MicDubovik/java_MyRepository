package ru.job4j.Food;

public class ControllQuality {
    private IStrategy strategy;

    public ControllQuality(IStrategy strategy) {
        this.strategy = strategy;
    }
    public void strategyMethod(Food food){
        strategy.addFood( food);
    }
}

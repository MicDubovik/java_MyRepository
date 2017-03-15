package ru.job4j.newFood;

public class ControllQuality {
    private IStorage storage;

    public ControllQuality(IStorage storage) {
        this.storage = storage;
    }
    public void strategyMethod(Food food){
        storage.addFood( food);
    }
}

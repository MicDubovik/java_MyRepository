package ru.job4j.newFood;

/**
 * ControllQuality
 */
public class ControllQuality {
    /**
     * IStorage.
     */
    private IStorage storage;

    /**
     * Constructor.
     * @param storage
     */
    public ControllQuality(IStorage storage) {
        this.storage = storage;
    }

    /**
     * strategyMethod.
     * @param food
     */
    public void strategyMethod(Food food){
        storage.addFood( food);
    }
}

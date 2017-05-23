package ru.job4j.newFood;

/**
 * Abstract class for expanding
 */
public  class AbstractShop implements IStorage {
    /**
     * IStorage
     */
    IStorage storage ;

    /**
     * Constructor.
     * @param storage
     */
    public AbstractShop(IStorage storage) {
        this.storage = storage;
    }

    /**
     * addFood.
     * @param food
     * @return
     */
    @Override
    public Food[] addFood(Food food) {
      return storage.addFood(food);
    }

    /**
     * removeProduct.
     * @param food
     * @return
     */
    @Override
    public Food[] removeProduct(Food food){
        return storage.removeProduct(food);
    }
}

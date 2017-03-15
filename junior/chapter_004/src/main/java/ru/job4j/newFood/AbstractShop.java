package ru.job4j.newFood;

/**
 * Abstract class for expanding
 */
public  class AbstractShop implements IStorage {

    IStorage storage ;

    public AbstractShop(IStorage storage) {
        this.storage = storage;
    }

    @Override
    public Food[] addFood(Food food) {
      return storage.addFood(food);
    }

    @Override
    public Food[] removeProduct(Food food){
        return storage.removeProduct(food);
    }
}

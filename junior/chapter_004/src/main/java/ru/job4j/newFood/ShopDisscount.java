package ru.job4j.newFood;

/**
 * ShopDisscount.
 */
public class ShopDisscount extends AbstractShop{

    /**
     * Constructor.
     * @param storage
     */
    public ShopDisscount(IStorage storage) {
        super(storage);
    }

    /**
     * addFood.
     * @param food
     * @return
     */
    public Food[] addFood(Food food){

         addDiscount(food);
       return  storage.addFood(food);
    }

    /**
     * removeProduct.
     * @param food
     * @return
     */
    public Food[] removeProduct(Food food){
       return this.storage.removeProduct(food);
    }
    public Food addDiscount(Food food){
        food.setDisscount(20);
        System.out.println("Add discount");
        return food;
    }
}

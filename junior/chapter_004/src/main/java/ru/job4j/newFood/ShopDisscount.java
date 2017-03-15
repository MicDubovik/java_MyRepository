package ru.job4j.newFood;

public class ShopDisscount extends AbstractShop{


    public ShopDisscount(IStorage storage) {
        super(storage);
    }

    public Food[] addFood(Food food){

         addDiscount(food);
       return  storage.addFood(food);
    }
    public Food[] removeProduct(Food food){
       return this.storage.removeProduct(food);
    }
    public Food addDiscount(Food food){
        food.setDisscount(20);
        System.out.println("Add discount");
        return food;
    }
}

package ru.job4j.newFood;

public class Shop implements IStorage {



   Food[] shopProducts = new Food[100];


    public Shop(  ) {

    }

    public Food[] getShopProducts() {
        return shopProducts;
    }

    @Override
    public Food[] addFood(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.shopProducts[i] == null) {
                this.shopProducts[i] = new Food();
                this.shopProducts[i] = food;break;
            }
        }
        System.out.println("Продукт добавлен в Shop ");
        return shopProducts;
    }
    public Food[] removeProduct(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.shopProducts[i]== null){
                this.shopProducts[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с  Shop ");
        return shopProducts;
    }



}

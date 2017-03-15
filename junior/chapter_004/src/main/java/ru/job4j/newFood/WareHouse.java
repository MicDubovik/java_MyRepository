package ru.job4j.newFood;

public class WareHouse implements IStorage {



   protected Food[] wareProducts =  new Food[100];


    public WareHouse( ) {

    }

    public Food[] addFood(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.wareProducts[i]== null){
                wareProducts[i] = new Food();
                this.wareProducts[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Warehouse ");
        return wareProducts;
    }
    public Food[] removeProduct(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.wareProducts[i]== null){
                this.wareProducts[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с Warehouse ");
        return wareProducts;
    }
}

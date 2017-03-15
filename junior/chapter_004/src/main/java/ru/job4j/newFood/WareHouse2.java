package ru.job4j.newFood;

public class WareHouse2 extends WareHouse {

   Food[] wareProducts = new Food[100];

    public Food[] addFood(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.wareProducts[i]== null){
                wareProducts[i] = new Food();
                this.wareProducts[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Warehouse2 ");
        return wareProducts;
    }
    public Food[] removeProduct(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.wareProducts[i]== null){
                this.wareProducts[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с Warehouse2 ");
        return wareProducts;
    }
}

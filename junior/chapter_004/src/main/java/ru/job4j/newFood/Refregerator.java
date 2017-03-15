package ru.job4j.newFood;

public class Refregerator implements IStorage {



   private Food[] refrProducts = new Food[100];


    public Refregerator(  ) {

    }

    @Override
    public Food[] addFood(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.refrProducts[i] == null) {
                this.refrProducts[i] = new Food();
                this.refrProducts[i] = food;break;
            }
        }
        System.out.println("Продукт добавлен в Refregerator (для переработки) ");
        return refrProducts;
    }
    public Food[] removeProduct(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.refrProducts[i]== null){
                this.refrProducts[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с  Shop ");
        return refrProducts;
    }



}

package ru.job4j.newFood;

public class Trash implements IStorage{



    Food[] trashProduct = new Food[100];

    public Trash(  ) {

    }

    @Override
    public Food[] addFood(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.trashProduct[i]== null){
                trashProduct[i] = new Food();
                this.trashProduct[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Trash ");
        return trashProduct;
    }
    public Food[] removeProduct(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.trashProduct[i]== null){
                this.trashProduct[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с Trash ");
        return trashProduct;
    }



}

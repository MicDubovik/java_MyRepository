package ru.job4j.Food;

public class Conversion extends Food implements IStrategy {
    private Food[] conversProducts = new Trash[100];

    public Conversion() {

    }

    public Conversion(String name, int expiryDate, String createDate, int price, int disscount, Food[] conversProducts) {
        super(name, expiryDate, createDate, price, disscount);
        this.conversProducts = conversProducts;
    }

    public Food[] addFood(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.conversProducts[i] != null) ;
            this.conversProducts[i] = new Food();
            this.conversProducts[i] = food;
            break;
        }
        System.out.println("Продукт добавлен в Trash ");
        return conversProducts;
    }
}

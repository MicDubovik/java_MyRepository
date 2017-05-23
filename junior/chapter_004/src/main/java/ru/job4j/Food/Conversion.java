package ru.job4j.Food;

/**
 * Conversion.
 */
public class Conversion extends Food implements IStrategy {
    /**
     * Array food.
     */
    private Food[] conversProducts = new Trash[100];

    /**
     * Constructor.
     */
    public Conversion() {

    }

    /**
     * Constructor.
     * @param name
     * @param expiryDate
     * @param createDate
     * @param price
     * @param disscount
     * @param conversProducts
     */
    public Conversion(String name, int expiryDate, String createDate, int price, int disscount, Food[] conversProducts) {
        super(name, expiryDate, createDate, price, disscount);
        this.conversProducts = conversProducts;
    }

    /**
     * Addfood.
     * @param food
     * @return
     */
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

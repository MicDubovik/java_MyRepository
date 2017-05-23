package ru.job4j.Food;

/**
 * Shop.
 */
public class Shop extends Food implements IStrategy {
    /**
     * Array foods.
     */
    private Food[] shopproducts = new Shop[100];

    /**
     * Constructor.
     */
    public Shop() {

    }

    /**
     * Constructor.
     *
     * @param name
     * @param expiryDate
     * @param createDate
     * @param price
     * @param disscount
     */
    public Shop(String name, int expiryDate, String createDate, int price, int disscount) {
        super(name, expiryDate, createDate, price, disscount);
    }

    /**
     * Method add product to Shop.
     *
     * @param food
     * @return
     */

    @Override
    public Food[] addFood(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.shopproducts[i] == null) {
                this.shopproducts[i] = new Food();
                this.shopproducts[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Shop ");
        return shopproducts;
    }

}
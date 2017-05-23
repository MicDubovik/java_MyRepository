package ru.job4j.Food;

/**
 * Warehouse.
 */
public class Warehouse extends Food implements IStrategy {

    /**
     * List wareProducts.
     */
    private Food[] wareProducts = new Food[100];

    /**
     * Constructor.
     */
    public Warehouse() {
    }

    /**
     * Constructor.
     * @param name
     * @param expiryDate
     * @param createDate
     * @param price
     * @param disscount
     */
    public Warehouse(String name, int expiryDate, String createDate, int price, int disscount) {
        super(name, expiryDate, createDate, price, disscount);
    }

    /**
     * Method add product in Warehouse.
     *
     * @param food
     * @return
     */
    @Override
    public Food[] addFood(Food food) {

        for (int i = 0; i < 100; i++) {
            if (this.wareProducts[i] == null) {
                wareProducts[i] = new Food();
                this.wareProducts[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Warehouse ");
        return wareProducts;
    }

    /**
     * Get.
     * @return
     */
    public Food[] getWareProducts() {
        return wareProducts;
    }

    /**
     * Set.
     * @param wareProducts
     */
    public void setWareProducts(Food[] wareProducts) {
        this.wareProducts = wareProducts;
    }
}

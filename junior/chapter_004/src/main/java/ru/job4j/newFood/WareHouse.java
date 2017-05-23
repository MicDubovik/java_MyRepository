package ru.job4j.newFood;

/**
 * WareHouse
 */
public class WareHouse implements IStorage {
    /**
     * List products.
     */
    protected Food[] wareProducts = new Food[100];

    /**
     *Constructor.
     */
    public WareHouse() {

    }

    /**
     * addFood.
     * @param food
     * @return
     */
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
     * removeProduct.
     * @param food
     * @return
     */
    public Food[] removeProduct(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.wareProducts[i] == null) {
                this.wareProducts[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с Warehouse ");
        return wareProducts;
    }
}

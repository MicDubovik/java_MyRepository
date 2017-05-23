package ru.job4j.newFood;

/**
 * Shop.
 */
public class Shop implements IStorage {
    /**
     * List products.
     */
    Food[] shopProducts = new Food[100];

    /**
     * Constructor.
     */
    public Shop() {

    }

    /**
     * Get.
     *
     * @return
     */
    public Food[] getShopProducts() {
        return shopProducts;
    }

    /**
     * addFood.
     *
     * @param food
     * @return
     */
    @Override
    public Food[] addFood(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.shopProducts[i] == null) {
                this.shopProducts[i] = new Food();
                this.shopProducts[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Shop ");
        return shopProducts;
    }

    /**
     * removeProduct.
     *
     * @param food
     * @return
     */
    public Food[] removeProduct(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.shopProducts[i] == null) {
                this.shopProducts[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с  Shop ");
        return shopProducts;
    }
}

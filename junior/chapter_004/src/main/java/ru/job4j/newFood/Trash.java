package ru.job4j.newFood;

/**
 * Trash
 */
public class Trash implements IStorage {
    /**
     * List product.
     */
    Food[] trashProduct = new Food[100];

    /**
     * Constructor.
     */
    public Trash() {

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
            if (this.trashProduct[i] == null) {
                trashProduct[i] = new Food();
                this.trashProduct[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Trash ");
        return trashProduct;
    }

    /**
     * removeProduct.
     *
     * @param food
     * @return
     */
    public Food[] removeProduct(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.trashProduct[i] == null) {
                this.trashProduct[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с Trash ");
        return trashProduct;
    }
}

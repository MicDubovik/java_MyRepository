package ru.job4j.newFood;

/**
 * Refregerator
 */
public class Refregerator implements IStorage {
    /**
     * Array food.
     */
    private Food[] refrProducts = new Food[100];

    /**
     * Constructor.
     */
    public Refregerator() {

    }

    /**
     * addFood.
     * @param food
     * @return
     */
    @Override
    public Food[] addFood(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.refrProducts[i] == null) {
                this.refrProducts[i] = new Food();
                this.refrProducts[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Refregerator (для переработки) ");
        return refrProducts;
    }

    /**
     * removeProduct.
     * @param food
     * @return
     */
    public Food[] removeProduct(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.refrProducts[i] == null) {
                this.refrProducts[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с  Shop ");
        return refrProducts;
    }

}

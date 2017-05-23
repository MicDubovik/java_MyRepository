package ru.job4j.newFood;

/**
 * WareHouse2.
 */
public class WareHouse2 extends WareHouse {
    /**
     * List products.
     */
   Food[] wareProducts = new Food[100];

    /**
     * Addfood.
     * @param food
     * @return
     */
    public Food[] addFood(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.wareProducts[i]== null){
                wareProducts[i] = new Food();
                this.wareProducts[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Warehouse2 ");
        return wareProducts;
    }

    /**
     * removeProduct.
     * @param food
     * @return
     */
    public Food[] removeProduct(Food food){
        for (int i = 0; i < 100; i++) {
            if (this.wareProducts[i]== null){
                this.wareProducts[i] = null;
                break;
            }
        }
        System.out.println("Продукт удален с Warehouse2 ");
        return wareProducts;
    }
}

package ru.job4j.Food;

public class ShopDisscount extends Food implements IStrategy  {

    private Food[] shopproducts = new Shop[100];

    /**
     * Method add product to ShopDisscount.
     * @param food
     * @return
     */
    @Override
    public Food[] addFood(Food food) {

        for (int i = 0; i < 100; i++) {
            if (this.shopproducts[i] == null) {
                shopproducts[i] = new Food();
                this.shopproducts[i] = food;
                this.shopproducts[i].setDisscount(20);
                break;
            }

        }
        return shopproducts;
    }
}


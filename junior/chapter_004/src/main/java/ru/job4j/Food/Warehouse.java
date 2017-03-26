package ru.job4j.Food;

public class Warehouse extends Food implements IStrategy {


    private Food[] wareProducts = new Food[100];

    public Warehouse() {
    }

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

    public Food[] getWareProducts() {
        return wareProducts;
    }

    public void setWareProducts(Food[] wareProducts) {
        this.wareProducts = wareProducts;
    }
}

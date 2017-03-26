package ru.job4j.Food;

public class WareHouse2 extends Food implements IStrategy {
    private Food[] ware2Products = new Food[100];

    public WareHouse2() {
    }

    public WareHouse2(String name, int expiryDate, String createDate, int price, int disscount) {
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
            if (this.ware2Products[i] == null) {
                ware2Products[i] = new Food();
                this.ware2Products[i] = food;
                break;
            }
        }
        System.out.println("Продукт добавлен в Warehouse ");
        return ware2Products;
    }

    public Food[] getWareProducts() {
        return ware2Products;
    }

    public void setWareProducts(Food[] wareProducts) {
        this.ware2Products = wareProducts;
    }
}

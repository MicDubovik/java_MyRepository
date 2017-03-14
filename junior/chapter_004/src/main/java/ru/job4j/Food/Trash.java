package ru.job4j.Food;

public class Trash extends Food implements IStrategy{
    private Food[] trashProducts = new Trash[100];

    public Trash( ) {

    }

    public Trash(String name, int expiryDate, String createDate, int price, int disscount) {
        super(name, expiryDate, createDate, price, disscount);
    }

    /**
     * Method add product to Trash.
     * @param food
     * @return
     */
    @Override
    public Food[] addFood(Food food) {
        for (int i = 0; i < 100; i++) {
            if (this.trashProducts[i] != null) ;
            trashProducts[i] = new Food();
            this.trashProducts[i] = food;break;
        }
        System.out.println("Продукт добавлен в Trash ");
        return  trashProducts;
    }
}

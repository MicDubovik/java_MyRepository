package ru.job4j.Food;

public class ListProducts {
    /**
     * List products .
     */
    Food[] foods = new Food[100];

    public Food[] cleanList(Food food) {

        for (int i = 0; i < foods.length; i++) {
            if (food.getCreateDate() == foods[i].getCreateDate()) {
                foods[i] = null;
                break;
            }
        }
        return foods;
    }
}

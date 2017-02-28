package ru.job4j.Tracker;

import java.util.Random;


/**
 * Класс обертка для работы с классом заявок
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int posission = 0;
    private static final Random RN = new Random();

    /**
     * Добавление заявки
     * @param item
     * @return
     */

    public Item add(Item item) {
        item.setId(generateId());
        this.items[posission++] = item;
        return item;
    }

    /**
     * Добавление комментария
     * @param comment
     * @param id
     */
    public void addComment(String comment, String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {

                items[i].setComment(comment);

            }
        }
    }

    /**
     * Редактирование заявки
     * @param id
     * @param comment
     * @param description
     */
    public void editItem(String id, String comment, String description) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i].setComment(comment);
                items[i].setDescription(description);
            }
        }
    }

    /**
     * Поиск по ключевому слову
     * @param word
     * @return
     */

    public Item findByComment(String word) {
        Item result = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getDescription().contains(word) || (items[i].getComment().contains(word))) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Удаление заявки
     * @param id
     */

    public void deleteItem(String id) {
        for (int i = 0; i < items.length-1; i++) {
            if (  items[i].getId().equals(id)) {
                items[i]=null;
                break;
            }
        }


    }

    /**
     * Поиск заявки по ID.
     * @param id
     * @return
     */

    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * метод генерации ID.
     * @return
     */

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Показать все заявки.
     * @return
     */
    public Item[] getAll() {
        Item[] result = new Item[this.posission];

        for (int index = 0; index != this.posission; index++) {

                result[index] = this.items[index];
        }

        return result;
    }



}

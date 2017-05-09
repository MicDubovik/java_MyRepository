package ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList;

import ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList.Database.InitDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Класс обертка для работы с классом заявок
 */
public class Tracker {

    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    InitDB initDB = new InitDB("items_db", "localhost", "5432", "postgres", "123");


    /**
     * Добавление заявки
     *
     * @param item
     * @return
     */

    public Item add(Item item) {
        if (item.getId() == null) {
            item.setId(generateId());
            this.items.add(item) ;
        } else this.items.add(item);
        return item;

    }

    /**
     * Добавление комментария
     *
     * @param comment
     * @param
     */
    public Item addComment(Item item, String comment) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(item.getId())) {

                items.get(i).setComment(comment);
                item = items.get(i);

            }
        }
        return item;
    }

    /**
     * Редактирование заявки
     *
     * @param
     * @param
     * @param
     */
    public Item editItem(Item olditem, Item newitem) {

        Item item = new Item();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(olditem.getId())) {
                items.get(i).setName(newitem.getName());
                items.get(i).setDescription(newitem.getDescription());
                item = items.get(i);
            }
        }
        return item;

    }

    /**
     * Поиск по ключевому слову
     *
     * @param word
     * @return
     */

    public Item findByComment(String word)  {
        Item result = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null  && (items.get(i).getDescription().contains(word) || (items.get(i).getComment().contains(word)))) {

                result = items.get(i);
                break;
            }
        }

        return result;
    }

    /**
     * Удаление заявки
     *
     * @param id
     */

    public void deleteItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
               items.remove(i) ;
                break;
            }
        }
    }

    /**
     * Поиск заявки по ID.
     *
     * @param id
     * @return
     */

    protected Item findById(String id) {
        Item result = null;
        for (Item items : this.items) {
            if (items != null && items.getId().equals(id)) {
                result = items;
                break;
            }
        }
        return result;
    }

    /**
     * метод генерации ID.
     *
     * @return
     */

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Показать все заявки.
     *
     * @return
     */
    public List<Item> getAll() {


        return items;
    }
}

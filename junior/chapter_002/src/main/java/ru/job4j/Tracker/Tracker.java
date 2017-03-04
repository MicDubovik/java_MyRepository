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
     *
     * @param item
     * @return
     */

    public Item add(Item item) {
        if (item.getId() == null) {
            item.setId(generateId());
            this.items[posission++] = item;
        } else this.items[posission++] = item;
        return item;
    }

    /**
     * Добавление комментария
     *
     * @param comment
     * @param
     */
    public Item addComment(Item item, String comment) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(item.getId())) {

                items[i].setComment(comment);
                item = items[i];

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
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(olditem.getId())) {
                items[i].setName(newitem.getName());
                items[i].setDescription(newitem.getDescription());
                item = items[i];
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

    public Item findByComment(String word) throws ItemNotFoundException {
        Item result = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getComment() != null && (items[i].getDescription().contains(word) || (items[i].getComment().contains(word)))) {

                result = items[i];
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
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
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


//        Item result = null;
////        boolean invalid = true;
////
////        do {
////            try {
//
//        for (Item item : items) {
//
//            if (item != null && item.getId().equals(id)  ) {
//                result = item;
////                        invalid = false;
//                break;
////                    } else {
////                        throw new MenuOutExeption("Not this ID.");
////                    }
//            }
//
////            } catch (MenuOutExeption moe) {
////                System.out.println("Please enter valid ID");
////            }
////        } while(invalid);
//        }
//        return result;
//    }

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
    public Item[] getAll() {
        Item[] result = new Item[this.posission];

        for (int index = 0; index != this.posission; index++) {

            result[index] = this.items[index];
        }

        return result;
    }


}

package ru.job4j.Generic;

/**
 * Store
 * @param <T>
 */
public interface Store<T extends Base> {
       /**
        * Add.
        * @param obj
        */
       void add(T obj);

       /**
        * Update.
        * @param obj
        * @param id
        */
       void update(T obj,String id);

       /**
        * Delete.
        * @param id
        */
       void delete(String id);

       /**
        * Get.
        * @param id
        * @return
        */
       T get(String id);
}

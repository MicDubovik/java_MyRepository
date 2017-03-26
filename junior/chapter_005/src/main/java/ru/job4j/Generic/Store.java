package ru.job4j.Generic;

public interface Store<T extends Base> {

       void add(T obj);

       void update(T obj,String id);

       void delete(String id);

       T get(String id);
}

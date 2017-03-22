package ru.job4j.Generic;

public interface Store<T extends Base> {

       void add(T obj);

       void update(T obj,int index);

       void delete(int index);

       T get(int index);
}

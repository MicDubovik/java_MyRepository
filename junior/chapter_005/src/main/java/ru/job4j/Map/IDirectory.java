package ru.job4j.Map;

public interface IDirectory<T, V> {

    boolean insert(T key, V value);

    V get(T key);

    boolean delete(T key);

}

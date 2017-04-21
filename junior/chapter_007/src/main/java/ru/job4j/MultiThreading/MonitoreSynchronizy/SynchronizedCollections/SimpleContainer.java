package ru.job4j.MultiThreading.MonitoreSynchronizy.SynchronizedCollections;

public interface SimpleContainer<E> extends Iterable<E> {

    void add(E e);

    E get(int index);
}

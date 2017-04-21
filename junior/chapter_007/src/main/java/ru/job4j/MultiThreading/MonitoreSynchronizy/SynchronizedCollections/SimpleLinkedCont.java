package ru.job4j.MultiThreading.MonitoreSynchronizy.SynchronizedCollections;

public interface SimpleLinkedCont<E> extends Iterable<E> {

    int size();

    void add(E e);

    E remove(int index);

    E get(int index);


}

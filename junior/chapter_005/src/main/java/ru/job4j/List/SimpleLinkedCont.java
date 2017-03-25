package ru.job4j.List;

public interface SimpleLinkedCont<E> extends Iterable<E> {

    int size();

    void add(E e);

    E remove(int index);

    E get(int index);


}

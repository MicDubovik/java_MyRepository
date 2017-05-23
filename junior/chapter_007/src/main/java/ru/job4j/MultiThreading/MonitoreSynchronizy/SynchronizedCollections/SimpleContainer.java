package ru.job4j.MultiThreading.MonitoreSynchronizy.SynchronizedCollections;

/**
 * SimpleContainer<E> .
 * @param <E>
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Add.
     * @param e
     */
    void add(E e);

    /**
     * Get.
     * @param index
     * @return
     */
    E get(int index);
}

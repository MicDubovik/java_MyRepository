package ru.job4j.List;

/**
 * SimpleContainer.
 * @param <E>
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * add.
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

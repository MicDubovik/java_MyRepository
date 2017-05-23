package ru.job4j.List;

/**
 * SimpleLinkedCont<E>.
 * @param <E>
 */
public interface SimpleLinkedCont<E> extends Iterable<E> {
    /**
     * Size.
     * @return
     */
    int size();

    /**
     * Add.
     * @param e
     */
    void add(E e);

    /**
     * Remove.
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * Get.
     * @param index
     * @return
     */
    E get(int index);


}

package ru.job4j.Generic;

/**
 * Class SimpleArray.
 * The task - add methods delete,update,get.
 *
 * @param <T>
 */
public class SimpleArray<T> {

    /**
     * Objects array.
     */
    private Object[] objects;
    /**
     * Index of array.
     */
    private int index = 0;

    /**
     * Constructor.
     *
     * @param size
     */

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Method for add object to array.
     *
     * @param obj
     */
    public void add(T obj) {
        this.objects[this.index++] = obj;
    }

    /**
     * Method for delete object from array.
     *
     * @param index
     */
    public void delete(int index) {
        this.objects[index] = null;
    }

    /**
     * Method for update array .
     * @param obj
     * @param index
     */

    public void update(T obj, int index) {
        this.objects[index] = obj;
    }

    /**
     * Methd get object from array.
     * @param index
     * @return
     */

    public T get(int index) {
        return (T) this.objects[index];
    }
}

package ru.job4j.List;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Dinamic arrayList.
 * @param <E>
 */

public class DinamicArrayList<E> implements SimpleContainer<E> {

    /**
     * Default size List.
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * Array objects.
     */
    private Object[] objects;
    /**
     * Index array.
     */
    private int index;

    /**
     * Constructor.
     */
    public DinamicArrayList( ) {
        this.objects =new Object[DEFAULT_SIZE];

    }

    /**
     * Constructor.
     * @param size
     */
    public DinamicArrayList( int size) {

        this.objects = new Object[size];
    }

    /**
     * Method add.
     * Check length array with index.If array length < index -> amplify length array.
     * @param o
     */
    @Override
    public void add(Object o) {
         if (this.index>=objects.length){
             this.objects = Arrays.copyOf(this.objects, this.objects.length *2);
         } else {
             this.objects[index++] = o;
         }

    }

    /**
     * get object from index.
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index>0 && index< this.objects.length){
            return (E) this.objects[index];
        }else {
            throw new  ArrayIndexOutOfBoundsException("Index out of bounds exception") ;
        }
    }

    /**
     * Create new Iterator for our array.
     * @return
     */
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E>{

        int position;

        /**
         * Override method hasNext().
         * @return
         */
        @Override
        public boolean hasNext() {
             boolean flag = true ? position > 0 && position<index : false;
             return flag;

        }

        /**
         * Override method next().
         * @return
         */
        @Override
        public E next() {
            return (E) objects[index++];
        }
    }
}

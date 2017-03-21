package ru.job4j.Iterator.IteratorMy;

import java.util.Iterator;

/**
 * Create Iterator for [][] array .
 */

public class IteratorForArray implements Iterator {

    private int[][] values;

    private int index1;
    private int index2;


    public IteratorForArray(int[][] values) {
        this.values = values;
    }

    /**
     * Override hasNext method.
     * @return
     */
    @Override
    public boolean hasNext() {
        if (this.values.length > this.index1 && this.values[0].length > this.index2 && index1 >= 0 && index2 >= 0) {
            return true;
        } else return false;
    }

    /**
     * Override next() method.
     * @return
     */

    @Override
    public Object next() {

        Integer result = null;
        result = this.values[index1][index2];
        if (this.index2 == this.values[index1].length - 1) {
            this.index2 = 0;
            this.index1++;
        } else {
            this.index2++;
        }

        return result;
    }

}

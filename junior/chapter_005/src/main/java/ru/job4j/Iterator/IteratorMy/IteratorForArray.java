package ru.job4j.Iterator.IteratorMy;

import java.util.Iterator;

/**
 * Create Iterator for [][] array .
 */

public class IteratorForArray implements Iterator {
    /**
     * Array values.
     */
    private int[][] values;
    /**
     * First index.
     */
    private int index1;
    /**
     * Second index.
     */
    private int index2;

    /**
     * Constructor.
     * @param values
     */
    public IteratorForArray(int[][] values) {
        this.values = values;
    }

    /**
     * Override hasNext method.
     * @return
     */
    @Override
    public boolean hasNext() {

            return this.values.length > this.index1 && this.values[0].length > this.index2 && index1 >= 0 && index2 >= 0;

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

package ru.job4j.Iterator.IteratorMy;

import java.util.Iterator;

/**
 * SimpleNumber
 */
public class SimpleNumber implements Iterator {
    /**
     * Array values.
     */
    private int[] values;
    /**
     * Index.
     */
    private int index;

    /**
     * Constructor.
     *
     * @param values
     */
    public SimpleNumber(int[] values) {
        this.values = values;
    }

    /**
     * hasNext.
     *
     * @return
     */
    @Override
    public boolean hasNext() {

        for (int i = this.index; i < this.values.length; i++) {
            if (check(this.values[i])) {
                this.index = i;
                return true;
            }
        }
        return false;

    }

    /**
     * Next.
     *
     * @return
     */
    @Override
    public Object next() {

        Integer result = null;
        for (int i = this.index; i < this.values.length; i++) {
            if (check(this.values[i])) {
                this.index = i + 1;
                result = this.values[i];
                break;
            }
        }
        return result;
    }

    /**
     * Check.
     *
     * @param num
     * @return
     */
    public boolean check(int num) {

        boolean result = true;
        if (num > 1) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

}





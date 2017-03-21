package ru.job4j.Iterator.IteratorMy;

import java.util.Iterator;

public class IteratorForEven implements Iterator {
    private int[] values;
    private int index = 0;

    public IteratorForEven(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean flag = false;
        for (int i = this.index; i < values.length; i++) {
            if (values[index] % 2 == 0) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Object next() {
        while (this.index < values.length) {
            if ((this.values[index] % 2 == 0)) {
                break;
            } else {
                index++;
            }
        }
        return values[index++];
    }


}

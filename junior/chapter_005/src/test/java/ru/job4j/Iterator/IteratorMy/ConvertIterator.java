package ru.job4j.Iterator.IteratorMy;

import java.util.Iterator;

public class ConvertIterator implements Iterator {

    private Iterator<Iterator<Integer>> firstIterators;

    private Iterator<Integer> secondIterator;

    public ConvertIterator(Iterator<Iterator<Integer>> firstIterators) {
        this.firstIterators = firstIterators;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if (!this.firstIterators.hasNext() && !this.secondIterator.hasNext()) {
            result = false;
        }
        return result;
    }


    @Override
    public Object next() {
        Integer result;
        if (this.secondIterator == null || !this.secondIterator.hasNext()) {
            this.secondIterator = this.firstIterators.next();
        }
        result = this.secondIterator.next();
        return result;
    }


}

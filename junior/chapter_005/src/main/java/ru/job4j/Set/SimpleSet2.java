package ru.job4j.Set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleSet2<E> implements ISetIntarface,Iterator {

    List<E> myset = new LinkedList<E>();

    int index;

    @Override
    public boolean hasNext() {
        boolean result = false;
        try {
            if (myset.get(index) != null) {
                result = true;
            }
        } catch (IndexOutOfBoundsException e) {
            result = false;
        }
        return result;
    }

    @Override
    public E next() {
        if (hasNext()){
            return myset.get(index++);
        } else {
            throw new NullPointerException("Position is empty.");
        }
    }

    @Override
    public void add(Object o)   {
        if (!myset.contains(o)){
            myset.add(((E) o));
        }else {
            myset.set( myset.indexOf(o), ((E) o)) ;
        }
    }
}

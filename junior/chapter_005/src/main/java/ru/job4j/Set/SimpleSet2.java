package ru.job4j.Set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * SimpleSet2<E>.
 * @param <E>
 */
public class SimpleSet2<E> implements ISetIntarface,Iterator {
    /**
     * List<E>.
     */
    List<E> myset = new LinkedList<E>();

    int index;

    /**
     * hasNext.
     * @return
     */
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

    /**
     * next.
     * @return
     */
    @Override
    public E next() {
        if (hasNext()){
            return myset.get(index++);
        } else {
            throw new NullPointerException("Position is empty.");
        }
    }

    /**
     * add.
     * @param o
     */
    @Override
    public void add(Object o)   {
        if (!myset.contains(o)){
            myset.add(((E) o));
        }else {
            myset.set( myset.indexOf(o), ((E) o)) ;
        }
    }
}

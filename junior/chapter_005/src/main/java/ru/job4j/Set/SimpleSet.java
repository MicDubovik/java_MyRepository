package ru.job4j.Set;

import java.util.Iterator;

/**
 * SimpleSet<E>.
 * @param <E>
 */
public class SimpleSet<E> implements ISetIntarface<E>, Iterator {

    /**
     * Index.
     */
    private int index;

    //    List<E> mySets = new ArrayList<>();
    /**
     * Array objects.
     */
    private Object[] mySets = new Object[10];

    /**
     * Setter.
     * @param mySets
     */
    public void setMySets(Object[] mySets) {
        this.mySets = mySets;
    }

    /**
     * hasNext.
     * @return
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        try {
            if (mySets[index] != null) {
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
        if (hasNext()) {
            return ((E) mySets[index++]);
        } else {
            throw new NullPointerException("Position is empty.");
        }
    }

    /**
     * Add.
     * @param e
     */
    @Override
    public void add(E e) {
        boolean flag = false;
        for (Object mySet : mySets) {
            if (mySet.equals(e)) {

                System.out.println("is not unique element");
            } else flag = true;
        }
        if (flag) {
            for (int i = 0; i < mySets.length; i++) {
                if (mySets[i] == null) {
                    mySets[i] = e;
                }
            }
        }
    }

}

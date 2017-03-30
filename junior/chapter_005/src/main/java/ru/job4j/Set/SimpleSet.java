package ru.job4j.Set;

import java.util.Iterator;

public class SimpleSet<E> implements ISetIntarface<E>, Iterator {


    private int index;

    //    List<E> mySets = new ArrayList<>();

    private Object[] mySets = new Object[10];


    public void setMySets(Object[] mySets) {
        this.mySets = mySets;
    }

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

    @Override
    public E next() {
        if (hasNext()) {
            return ((E) mySets[index++]);
        } else {
            throw new NullPointerException("Position is empty.");
        }
    }

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

//    public static void main(String[] args) throws Exception {
//
//        SimpleSet<String> simpleSet = new SimpleSet();
//
//        String str = "Hello";
//        String str2 = "World";
//
//        simpleSet.add( str);
//        simpleSet.add(str2);
//        simpleSet.add(str);
//
//        for (String s : simpleSet.mySets) {
//            System.out.println(s);
//        }
//        int i=0;
//        while (simpleSet.hasNext()){
//            simpleSet.next();
//            System.out.println(simpleSet.mySets.get(i));
//            i++;
//        }
//
//
//
//
//    }
}

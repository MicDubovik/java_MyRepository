package ru.job4j.Set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleSet<E>   implements ISetIntarface,Iterator {


   private int index;


    List<E> mySets = new ArrayList<>();


    @Override
    public boolean hasNext() {
        boolean result = false;
        try {
            if (mySets.get(index) != null) {
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
            return mySets.get(index++);
        } else {
            throw new NullPointerException("Position is empty.");
        }
    }

    @Override
    public void add(Object o)   {
        if (!mySets.contains(o)){
            mySets.add(((E) o));
        }else {
            mySets.set( mySets.indexOf(o), ((E) o)) ;
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

package ru.job4j.CollectionFramework;

import java.util.*;

import static java.lang.System.arraycopy;
import static java.lang.System.setOut;

/**
 * Created by Katy on 26.05.2017.
 */
public class TestList {

    public void merge(List a, List b) {

        a.addAll(b);
        Collections.sort(a);
    }

    public void mergeSorted(List a, List b) {

        Set<Integer> sortedSet = new TreeSet<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        sortedSet.addAll(a);
        sortedSet.addAll(b);
    }


    public void listSort(List a, List b) {
         Collections.sort(b);
        List<Integer> z = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if ((Integer) a.get(i) < (Integer) b.get(j)) {
                z.add((Integer) a.get(i));
                i++;
            } else {
                z.add((Integer) b.get(j));
                j++;
            }
        }
        if (b.size() > a.size()) {
            while (j < b.size()) {
                z.add((Integer) b.get(j));
                j++;
            }
        }
    }
    public void linkedSort(List a, List b) {

        Collections.sort(b);
        List<Integer> z = new LinkedList<>();
        int i = 0;
    int j = 0;
        while (i < a.size() && j < b.size()) {
        if ((Integer) a.get(i) < (Integer) b.get(j)) {
            z.add((Integer) a.get(i));
            i++;
        } else {
            z.add((Integer) b.get(j));
            j++;
        }
    }

        if (b.size() > a.size()) {
        while (j < b.size()) {
            z.add((Integer) b.get(j));
            j++;
        }
    }
}


    int FindIndex(List  list, int el)
    {
        if (list.size() == 0)
        {
            return 0;
        }
        if (((Integer) list.get(list.size() - 1)) < el)
        {
            return  list.size();
        }
        int i = 0;
        int j = list.size();
        while (i + 1 < j)
        {
            int middle = i + (j - i) / 2;
            if (((Integer) list.get(middle)) >= el)
            {
                j = middle;
            }
            else
            {
                i = middle;
            }
        }
        return ((Integer) list.get(i)) >= el ? i : j;
    }

    public List<Integer> BinarySort(List<Integer> list )
    {
        List<Integer> li = new ArrayList<>();
        int index =0;
        for (int i = 0; i < list.size(); i++)
        {
            index = FindIndex(li, list.get(i));
            li.add(index, list.get(i));
        }
         return li;
    }

    public void binary(List a,List b){

        List<Integer> z = new LinkedList<>();

        BinarySort(b) ;

        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if ((Integer) a.get(i) < (Integer) b.get(j)) {
                z.add((Integer) a.get(i));
                i++;
            } else {
                z.add((Integer) b.get(j));
                j++;
            }
        }
        if (b.size() > a.size()) {
            while (j < b.size()) {
                z.add((Integer) b.get(j));
                j++;
            }
        }
    }

    public static void main(String[] args) {
        TestList testList = new TestList();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            a.add(new Random().nextInt(1000000));
        }
        for (int i = 0; i < 1000000; i++) {
            b.add(new Random().nextInt(1000000));
        }


        Collections.sort(a);

        long start = System.currentTimeMillis();
        testList.merge(a, b);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        long start2 = System.currentTimeMillis();
        testList.mergeSorted(a, b);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);






        long start3 = System.currentTimeMillis();
        testList.listSort(a,b);
        long end3 = System.currentTimeMillis();

        System.out.println("listSort: "+(end3 - start3));

        long start4 = System.currentTimeMillis();
        testList.linkedSort(a,b);
        long end4 = System.currentTimeMillis();

        System.out.println("LinkedSort: "+(end4 - start4));


        long start5 = System.currentTimeMillis();
        testList.binary(a,b);
        long end5 = System.currentTimeMillis();

        System.out.println("BinarySort: "+(end5 - start5));


    }
}

package ru.job4j.CollectionFramework;

import java.util.*;

/**
 * TestCollections
 */
public class TestCollections {
    /**
     * addю
     * @param collection
     * @param line
     * @param amount
     * @return
     */
    public long add(Collection<String> collection, String line, int amount) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(line);
        }
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        return timeConsumedMillis;

    }

    /**
     * deleteю
     * @param collection
     * @param line
     * @param amount
     * @return
     */
    public long delete(Collection<String> collection, String line, int amount) {
        long start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.remove(line);
        }
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        return timeConsumedMillis;
    }

    /**
     * ьфштю
     * @param args
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> linked = new LinkedList<>();
        Set<String> treeset = new TreeSet<>();
        String string = "Hello dfgdsgsdfhsfhfdjghkhjkhjkgghghkhghjkhkghjkghkh";

        TestCollections testSpeed = new TestCollections();

        int num = 100000;

        System.out.println("Time for add ArrayList<> = "+testSpeed.add(list,string,num));
        System.out.println("Time for add LinkedList<> = "+testSpeed.add(linked,string,num));
        System.out.println("Time for add TreeList<> = "+testSpeed.add(treeset,string,num));

        System.out.println();
        System.out.println("Time for remove ArrayList<> = "+testSpeed.delete(list,string,num));
        System.out.println("Time for remove LinkedList<> = "+testSpeed.delete(linked,string,num));
        System.out.println("Time for remove TreeList<> = "+testSpeed.delete(treeset,string,num));

    }
}

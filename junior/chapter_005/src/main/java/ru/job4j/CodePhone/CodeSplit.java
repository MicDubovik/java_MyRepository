package ru.job4j.CodePhone;

import java.util.*;

/**
 * CodeSplit.
 */
public class CodeSplit {

    /**
     * SortedSet for keep my separated array strings.
     */
    TreeSet<String> sortedSet = new TreeSet<>();
    /**
     *  List for keep reverse Codes.
     */
    TreeSet<String> reverseSet ;

    /**
     * Method for cut array on the string.
     * @param string
     */
    public void cutArray(String[] string) {

        String temp = null;
        for (int i = 0; i < string.length; i++) {
            temp = string[i];

            sortedSet.add(temp);

            while (temp.contains("/")) {

                temp = temp.substring(0, temp.lastIndexOf("/"));

                sortedSet.add(temp);
            }

        }
    }

    /**
     * Method for get reverse list codes.
     * @param treeSet
     * @return
     */
    public TreeSet<String> reverse(TreeSet<String> treeSet){

        // Здесь я сделал новый компаратор , но не знаю  как его применить к уже
        // имеющемуся treeSet , поэтому создал новый reverseSet, закинул в него
        // имеющуюся коллекцию и отсортировал с новым компаратором.
        //  Как использовать новый компаратор к treeSet , не создавая новую коллекцию ???

         Comparator<String> newcomparator =  new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return comp(o1,o2);
             }
         };

        this.reverseSet = new TreeSet<>(newcomparator);
        this.reverseSet.addAll(treeSet);

      return (TreeSet<String>) this.reverseSet.descendingSet();

    }
    /**
     * Modified method compareTo from class String for reverse sort.
     * @param anotherString
     * @param current
     * @return
     */
    public int comp(String anotherString, String current) {

        char value[] = current.toCharArray();
        char value2[] = anotherString.toCharArray();
        int len1 = value.length;
        int len2 = value2.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = value2;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c2 - c1;
            }
            k++;
        }
        return len1 - len2;
    }

    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {

        String[] strings = {"K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};


        CodeSplit split = new CodeSplit();

        split.cutArray(strings);
        System.out.println("================");
        System.out.println(" Ascending sort ");
        System.out.println("================");
        for (String s : split.sortedSet) {
            System.out.println(s);
        }
        System.out.println("----------------------------");
        System.out.println("=================");
        System.out.println(" Descending sort ");
        System.out.println("=================");
        for (String string : split.reverse(split.sortedSet)) {
            System.out.println(string);
        }
    }
}

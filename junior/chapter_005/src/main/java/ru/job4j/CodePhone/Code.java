package ru.job4j.CodePhone;

import java.util.*;

public class Code {

    TreeSet<String> sortedSet = new TreeSet<>();

    List<String> list = new ArrayList<>();

    Set<String> tempSet = new TreeSet<>();

    public void sortNumberFromString(String[] strings) {

        /**
         * List for keep my separated string.
         */

        /**
         * Add string to my sortedSet.
         */
        for (int i = 0; i < strings.length; i++) {
            sortedSet.add(strings[i]);

        }
        list.addAll(sortedSet);
    }
    public void showInputList() {
        System.out.println(sortedSet + " set");
        System.out.println(list + " Array");
    }
     public void addNewCode() {
         /**
          * Value number for first separated code.
          */
         int value1 = 2;
         /**
          * Value number for second separated code.
          */
         int value2 = 6;
         /**
          * Value number for third separated code.
          */
         int value3 = 11;
         boolean flag = true;
         for (int i = 0; i < list.size() - 1; i++) {

             String temp = list.get(0);
             String current = list.get(i);
             String next = list.get(i + 1);
             if (flag && temp.length() > value1) {
                 String newCode = list.get(1).substring(0, value1);
                 tempSet.add(newCode);
                 flag = false;
             }
             if (next.length() > current.length() && (next.length() - current.length()) > value2) {
                 String newCode = next.substring(0, value2);
                 tempSet.add(newCode);
             }
         }
         sortedSet.addAll(tempSet);
     }

     public void showNewList(){

         for (String s : sortedSet) {
             System.out.println(s);
         }
     }

        public   TreeSet<String> reversList(){
     TreeSet<String> reversSet = (TreeSet<String>) sortedSet.descendingSet();

        return reversSet;

    }
    public void showReverse(TreeSet<String> treeSet){
        for (String s : treeSet) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Code code = new Code();
        String[] strings = {"K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};

        code.sortNumberFromString(strings);

        code.showInputList();
        System.out.println("--------------------------------------------------------------------------");

        code.addNewCode();
        code.showNewList();

        System.out.println("--------------------------------------------------------------------------");
        code.showReverse(code.reversList());
    }
}
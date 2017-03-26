package ru.job4j.Test;

import java.util.LinkedList;
import java.util.List;

public class Node {//implements Iterator{
    int value;
    Node next;


    public Node(int value) {
        this.value = value;
    }

//    @Override
//    public boolean hasNext() {
//        if (next.next()!=null)
//        return true;
//        else return false;
//    }
//
//    @Override
//    public Node next() {
//
//            return next;
//    }

    public static void main(String[] args) {

        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        List<Node> numbers = new LinkedList<>();


        numbers.add(first);
        numbers.add(two);
        numbers.add(third);
        numbers.add(four);

        int i = 0;
        while (numbers.iterator().hasNext()){
            System.out.println(numbers.iterator().next().value);
            i++;
            System.out.println(numbers.get(i).value);
        }





//        for (int i = 0; i < numbers.size()+1; i++) {
//
//            if (i+1==5){
//                System.out.println(true);
//            }
//
//        }




//        System.out.println(first.next().value);
//        System.out.println(two.next().value);
//        System.out.println(first.next().value);
//        System.out.println(first.next().value);
//        System.out.println(four.hasNext());
//        System.out.println(four.next().value);











    }



}

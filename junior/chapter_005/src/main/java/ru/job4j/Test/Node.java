package ru.job4j.Test;

public class Node  {
    int value;
    Node  next;


    public Node(int value) {
        this.value = value;
    }

//    public boolean hasCycle(Node first){
//        boolean flag =false;
//
//
//
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







    }


}

package ru.job4j.Test;

//  class Node {
//
//    Node next;
//    int value;
//
//    public Node(Node next, int value) {
//        this.next = next;
//        this.value = value;
//    }
//
//    public Node add(int value) {
//        this.next = new Node(null, value);
//        return this.next;
//    }
//
//
//    public static void main(String[] args) {
//
//
//        Node first = new Node(null, 1);
//        Node second = new Node(null, 2);
//        Node third = new Node(null, 3);
//
//
//        first.next =second;
//        second.next = third;
//
//        List<Node> nodeList = new ArrayList<>();
//
//        nodeList.add(first);
//        nodeList.add(second);
//        nodeList.add(third);
//
//        System.out.println( nodeList.get(1).next.value);
//
//    }
//}
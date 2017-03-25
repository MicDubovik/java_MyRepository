package ru.job4j.List;

public class MyQueue<E> extends MyLinkedList {

    MyLinkedList<E> myLinkedList = new MyLinkedList();

    public void push(E e ){

        myLinkedList.add(e);
    }

    public E pop(){
        E result = myLinkedList.get(0);
        myLinkedList.remove(0);
        return result;
    }

}

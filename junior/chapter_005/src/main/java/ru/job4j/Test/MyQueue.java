package ru.job4j.Test;

import ru.job4j.List.MyLinkedList;

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

class MySrack<E> extends MyLinkedList{

    MyLinkedList<E> myLinkedList = new MyLinkedList();

    public void push(E e ){

        myLinkedList.add(e);
    }

    public E pop(){
        E result = myLinkedList.get(myLinkedList.size()-1);
        myLinkedList.remove(myLinkedList.size()-1);
        return result;
    }
}

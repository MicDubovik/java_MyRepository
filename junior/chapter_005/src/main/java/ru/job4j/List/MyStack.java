package ru.job4j.List;

public class MyStack<E> extends MyLinkedList {



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


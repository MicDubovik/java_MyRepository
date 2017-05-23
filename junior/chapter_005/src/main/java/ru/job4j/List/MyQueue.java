package ru.job4j.List;

/**
 * MyQueue
 * @param <E>
 */
public class MyQueue<E> extends MyLinkedList {
    /**
     * LinkedList<E> .
     */
    MyLinkedList<E> myLinkedList = new MyLinkedList();

    /**
     * push.
     * @param e
     */
    public void push(E e ){

        myLinkedList.add(e);
    }

    /**
     * pop.
     * @return
     */
    public E pop(){
        E result = myLinkedList.get(0);
        myLinkedList.remove(0);
        return result;
    }

}

package ru.job4j.List;

/**
 * Stack.
 *
 * @param <E>
 */
public class MyStack<E> extends MyLinkedList {
    /**
     *LinkedList<E>.
     */
    MyLinkedList<E> myLinkedList = new MyLinkedList();

    /**
     * push.
     * @param e
     */
    public void push(E e) {

        myLinkedList.add(e);
    }

    /**
     * pop.
     * @return
     */
    public E pop() {
        E result = myLinkedList.get(myLinkedList.size() - 1);
        myLinkedList.remove(myLinkedList.size() - 1);
        return result;
    }
}


package ru.job4j.List;


import java.util.Iterator;

/**
 * Cycle.
 */
public class Cycle implements Iterator {
    /**
     * Value.
     */
    int value;
    /**
     * Reference to next object.
     */
    Cycle next;

    /**
     * Constructor.
     * @param value
     */
    public Cycle(int value) {
        this.value = value;
    }

    /**
     * hasNext.
     * @return
     */
    @Override
    public boolean hasNext() {
        if (next.next() != null)
            return true;
        else return false;
    }

    /**
     * Next.
     * @return
     */
    @Override
    public Cycle next() {

        return next;
    }

    /**
     * Check - isCycle.
     * @return
     */
    public boolean isCycle() {

        Cycle fast = this;
        Cycle slow = this;

        while (true) {
            fast = fast.next().next();
            slow = slow.next();
            if (fast==null || slow==null){
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
    }

    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {

        Cycle first = new Cycle(1);
        Cycle two = new Cycle(2);
        Cycle third = new Cycle(3);
        Cycle four = new Cycle(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        System.out.println(first.isCycle());

//        List<Cycle> numbers = new LinkedList<>();
//
//
//
//        numbers.add(first);
//        numbers.add(two);
//        numbers.add(third);
//        numbers.add(four);
//
//
//        for (int i = 0; i < numbers.size() + 21; i++) {
//
//            if (i + 1 > numbers.size()) {
//                System.out.println(true);
//            }
//
//        }
    }
}
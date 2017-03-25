package ru.job4j.Test;

public class Entry {


    private String Entry;
    /**
     * Reference to previous Entry.
     */
    private Entry previousEntry;
    /**
     * Reference to next Entry.
     */
    private Entry nextEntry;

    /**
     * Constructor.
     *
     * @param previous - reference to previous Entry.
     * @param Entry    - container Entry.
     * @param next     - reference to next Entry.
     */
    Entry(Entry previous, String Entry, Entry next) {
        this.previousEntry = previous;
        this.Entry = Entry;
        this.nextEntry = next;
    }
}
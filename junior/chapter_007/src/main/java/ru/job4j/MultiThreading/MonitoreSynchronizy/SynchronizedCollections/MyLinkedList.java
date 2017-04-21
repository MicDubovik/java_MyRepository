package ru.job4j.MultiThreading.MonitoreSynchronizy.SynchronizedCollections;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList<E> implements SimpleLinkedCont<E> {

    private int size = 0;

    private Entry<E> firstEntry;

    private Entry<E> lastEntry;

    /**
     * Get count of Entrys.
     *
     * @return count of Entrys in container.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Add new Entry to container.
     *
     * @param Entry - new Entry.
     */
    @Override
    public synchronized void add(E Entry) {
        Entry<E> newEntry = new Entry(this.lastEntry, Entry, null);
        if (this.lastEntry == null) {
            this.firstEntry = newEntry;
        } else {
            this.lastEntry.setNextEntry(newEntry);
        }
        this.lastEntry = newEntry;
        size++;
    }

    /**
     * Get Entry by index.
     *
     * @param index - index of Entry.
     * @return Entry.
     */
    @Override
    public synchronized E get(int index) {
        checkIndex(index);

        return getEntryByIndex(index).getEntry();

    }

    /**
     * Delete Entry from container by index.
     *
     * @param index - index of Entry.
     * @return deleted Entry.
     */
    @Override
    public synchronized E remove(int index) {

        checkIndex(index);

        Entry<E> removedEntry = getEntryByIndex(index);
        Entry<E> previous = removedEntry.getPreviousEntry();
        Entry<E> next = removedEntry.getNextEntry();
        if (previous == null) {
            this.firstEntry = next;
        } else {
            previous.setNextEntry(next);
            removedEntry.setPreviousEntry(null);
        }
        if (next == null) {
            this.lastEntry = previous;
        } else {
            next.setPreviousEntry(previous);
            removedEntry.setNextEntry(null);
        }
        removedEntry.setEntry(null);
        size--;
        return removedEntry.getEntry();
    }


    /**
     * Get iterator.
     *
     * @return iterator for linked list.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    /**
     * Get Entry by index.
     *
     * @param index - index of Entry.
     * @return Entry.
     */
    private Entry<E> getEntryByIndex(int index) {
        Entry<E> result;
        if (index < (size >> 1)) {
            result = this.firstEntry;
            for (int i = 0; i < index; i++) {
                result = result.getNextEntry();
            }
        } else {
            result = this.lastEntry;
            for (int i = size - 1; i > index; i--) {
                result = result.getPreviousEntry();
            }
        }
        return result;
    }

    /**
     * Index validation.
     *
     * @param index - index for checking.
     */
    private void checkIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    /**
     * My iterator for linked list.
     */
    private class MyLinkedListIterator implements Iterator<E> {

        /**
         * Current Entry of linked list.
         */
        private Entry<E> current = firstEntry;

        /**
         * Check next Entry in container.
         *
         * @return true if Entry exists.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Get next Entry from container.
         *
         * @return next Entry.
         */
        @Override
        public E next() {
            if (hasNext()) {
                E result = current.getEntry();
                current = current.getNextEntry();
                return result;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    private class Entry<E> {


        private E Entry;
        /**
         * Reference to previous Entry.
         */
        private Entry<E> previousEntry;
        /**
         * Reference to next Entry.
         */
        private Entry<E> nextEntry;

        /**
         * Constructor.
         *
         * @param previous - reference to previous Entry.
         * @param Entry    - container Entry.
         * @param next     - reference to next Entry.
         */
        Entry(Entry<E> previous, E Entry, Entry<E> next) {
            this.previousEntry = previous;
            this.Entry = Entry;
            this.nextEntry = next;
        }

        /**
         * Getter.
         *
         * @return Entry.
         */
        public E getEntry() {
            return this.Entry;
        }

        /**
         * Setter.
         *
         * @param Entry new Entry's value.
         */
        public void setEntry(E Entry) {
            this.Entry = Entry;
        }

        /**
         * Getter.
         *
         * @return - reference to previous Entry.
         */
        public Entry<E> getPreviousEntry() {
            return this.previousEntry;
        }

        /**
         * Setter.
         *
         * @param previousEntry - new reference to previous Entry.
         */
        public void setPreviousEntry(Entry<E> previousEntry) {
            this.previousEntry = previousEntry;
        }

        /**
         * Getter.
         *
         * @return - reference to next Entry.
         */
        public Entry<E> getNextEntry() {
            return this.nextEntry;
        }

        /**
         * Setter.
         *
         * @param nextEntry - new reference to next Entry.
         */
        public void setNextEntry(Entry<E> nextEntry) {
            this.nextEntry = nextEntry;
        }
    }
}

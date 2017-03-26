package ru.job4j.Map;

import java.util.Arrays;
import java.util.Iterator;

public class Directory<T,V> implements IDirectory<T,V> {

    /**
     * Array Entry.
     */
    private Entry<T, V>[] array;

    /**
     * index.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param size
     */

    public Directory(int size) {
        array = new Entry[size];
    }

    /**
     * Method for insert.
     * @param key
     * @param value
     * @return
     */

    public boolean insert(T key, V value) {
        boolean result = true;
        if (key == null) {
            result = false;
        } else if (checkNew(key, value)) {
            add(key, value);
        }
        return result;
    }

    /**
     * Chek for new element.
     * @param key
     * @param value
     * @return
     */
    private boolean checkNew(T key, V value) {
        boolean result = true;
        if (this.array[getIndex(key)] != null) {
            this.array[getIndex(key)].setValue(value);
            result = false;
        }
        return result;
    }

    /**
     * GetIndex.
     * @param key
     * @return
     */

    private int getIndex(T key) {
        return key.hashCode() % this.array.length;
    }

    /**
     * Add element.
     * @param key  element.
     * @param value element.
     */
    public void add(T key, V value) {
        if (this.index >= this.array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length * 2);
        }
        this.array[getIndex(key)] = new Entry<>(key, value);
        this.index++;
    }

    /**
     * Get.
     * @param key value.
     * @return V.
     */

    public V get(T key) {
        return this.array[getIndex(key)].getValue();
    }

    /**
     * Delete.
     * @return boolean.
     */



    /**
     * Delete.
     * @param key value.
     * @return boolean.
     */

     public boolean delete(T key) {
        boolean result = true;
        if (key == null) {
            result = false;
        } else {
            if (this.array[getIndex(key)] != null) {
                this.array[getIndex(key)] = null;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Returns iterator.
     * @return  .
     */

    public Iterator<V> iterator() {
        return new DirectoryIterator<>();
    }

    /**
     * Entry.
     * @param <P>
     * @param <N>
     */
    private class Entry<P, N> {
        /**
         * Key.
         */
        private P key;
        /**
         * Value.
         */
        private N value;

        /**
         * Entry constructor.
         * @param key element.
         * @param value element.
         */
        Entry(P key, N value) {
            this.key = key;
            this.value = value;
        }

        /**
         * GetKey.
         * @return key.
         */
        public P getKey() {
            return this.key;
        }

        /**
         * GetValue.
         * @return value.
         */
        public N getValue() {
            return this.value;
        }

        /**
         * SetValue.
         * @param value
         */
        public void setValue(N value) {
            this.value = value;
        }
    }

    /**
     * Iterator.
     * @param <N>
     */
    private class DirectoryIterator<N> implements Iterator<N> {
        /**
         * Position.
         */
        private int position = 0;
        /**
         * Has next.
         */
        @Override
        public boolean hasNext() {
            boolean result = false;
            for (int i = position; i < array.length; i++) {
                if (array[i] != null) {
                    result = true;
                    break;
                } else {
                    position++;
                }
            }
            return result;
        }

        /**
         * Next.
         */
        @Override
        public N next() {
            if (this.hasNext()) {
                return (N) array[position++].getValue();
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
}

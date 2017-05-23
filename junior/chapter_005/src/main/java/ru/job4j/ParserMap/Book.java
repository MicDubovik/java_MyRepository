package ru.job4j.ParserMap;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Class Book.
 */
public class Book {
    /**
     * Name of the book.
     */
    private String name;
    /**
     * For store bid orders of book.
     */
    private TreeMap<Double, Integer> buyBooks = new TreeMap<>(new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return -o1.compareTo(o2);
        }
    });
    /**
     * For store ask ordrers of book.
     */
    private TreeMap<Double, Integer> sellBooks = new TreeMap<>();

    /**
     * Constructor.
     * @param name name
     */
    public Book(String name) {
        this.name = name;
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for bid set.
     * @return treemap of bid
     */
    public TreeMap<Double, Integer> getBuyBooks() {
        return buyBooks;
    }

    /**
     * Getter for ask set.
     * @return set of ask order
     */
    public TreeMap<Double, Integer> getSellBooks() {
        return sellBooks;
    }

    /**
     * equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return name.equals(book.name);
    }

    /**
     * hashCode.
     * @return
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }


}
package ru.job4j.MyParserMap;

import java.util.*;

/**
 * Book.
 */
public class Book {
    /**
     * Name.
     */
    private String name;
    /**
     * Map<Double,Integer>.
     */
    private Map<Double,Integer> bookBuy ;
    /**
     * Map<Double,Integer>.
     */
    private Map<Double,Integer> bookSell ;

    /**
     * Constructor.
     * @param name
     */
    public Book(String name) {
        this.name = name;
        this.bookBuy = new TreeMap<>((Double o1, Double o2) -> o1.compareTo(o2));
        this.bookSell = new TreeMap<>((Double o1, Double o2) -> o2.compareTo(o1));

    }

    /**
     * Get.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get.
     * @return
     */
    public Map<Double, Integer> getBookBuy() {
        return bookBuy;
    }

    /**
     * Set.
     * @param bookBuy
     */
    public void setBookBuy(Map<Double, Integer> bookBuy) {
        this.bookBuy = bookBuy;
    }
    /**
     * Get.
     * @return
     */
    public Map<Double, Integer> getBookSell() {
        return bookSell;
    }

    /**
     * Set.
     * @param bookSell
     */
    public void setBookSell(Map<Double, Integer> bookSell) {
        this.bookSell = bookSell;
    }

    /**
     * equals.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return name != null ? name.equals(book.name) : book.name == null;
    }

    /**
     * hashCode.
     * @return
     */
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}


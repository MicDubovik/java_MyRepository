package ru.job4j.MyParserMap;

import java.util.*;

public class Book {

    private String name;

    private Map<Double,Integer> bookBuy ;

    private Map<Double,Integer> bookSell ;

    public Book(String name) {
        this.name = name;
        this.bookBuy = new TreeMap<>((Double o1, Double o2) -> o1.compareTo(o2));
        this.bookSell = new TreeMap<>((Double o1, Double o2) -> o2.compareTo(o1));

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Double, Integer> getBookBuy() {
        return bookBuy;
    }

    public void setBookBuy(Map<Double, Integer> bookBuy) {
        this.bookBuy = bookBuy;
    }

    public Map<Double, Integer> getBookSell() {
        return bookSell;
    }

    public void setBookSell(Map<Double, Integer> bookSell) {
        this.bookSell = bookSell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return name != null ? name.equals(book.name) : book.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}


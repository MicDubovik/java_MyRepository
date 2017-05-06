package ru.job4j.ParserMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * Class order of book.
 */
public class OrderBook {
    /**
     * HashMap of book and order of this book.
     */
    private HashMap<Book, HashSet<Order>> books;

    /**
     * Constructor.
     */
    public OrderBook() {
        this.books = new HashMap<>();
    }

    /**
     * Getter.
     * @return hashmap of books and book's orders
     */
    public HashMap<Book, HashSet<Order>> getBooks() {
        return books;
    }

    /**
     * Add order to the book.
     * @param book book
     * @param order order
     */
    public void addBook(Book book, Order order) {
        books.get(book).add(order);
    }

    /**
     * Delete order from the book.
     * @param book book
     * @param order order
     */
    public void deleteBook(Book book, Order order) {
        books.get(book).remove(order);
    }

    /**
     * Sort orders for all books by buy and sel orders.
     * @param orders orders
     */
    public void sort(HashMap<Book, HashSet<Order>> orders) {
        for (Book book : orders.keySet()) {
            TreeMap<Double, Integer> buy = book.getBuyBooks();
            TreeMap<Double, Integer> sel = book.getSellBooks();
            HashSet<Order> tmp = orders.get(book);
            for (Order order : tmp) {
                if (order.getAction().equals("BUY")) {
                    sortOrder(buy, sel, order);
                } else {
                    sortOrder(sel, buy, order);
                }
            }
        }
    }

    /**
     * Sorting sell and buy orders.
     * @param buy set of buy orders
     * @param sel set of sell ordres
     * @param order oreder
     */
    public void sortOrder(TreeMap<Double, Integer> buy, TreeMap<Double, Integer> sel, Order order) {
        if (sel.containsKey(order.getPrice())) {
            if (sel.get(order.getPrice()) < order.getVolume()) {
                if (buy.containsKey(order.getPrice())) {
                    buy.put(order.getPrice(), min(order.getVolume(), sel.get(order.getPrice())) + buy.get(order.getPrice()));
                } else {
                    buy.put(order.getPrice(), min(order.getVolume(), sel.get(order.getPrice())));
                }
                sel.remove(order.getPrice());
            } else if (sel.get(order.getPrice()) > order.getVolume()) {
                sel.put(order.getPrice(), min(sel.get(order.getPrice()), order.getVolume()));
            } else {
                sel.remove(order.getPrice());
            }
        } else {
            if (buy.containsKey(order.getPrice())) {
                buy.put(order.getPrice(), buy.get(order.getPrice()) + order.getVolume());
            } else {
                buy.put(order.getPrice(), order.getVolume());
            }
        }
    }

    /**
     * Take difference between orders volume.
     * @param first first
     * @param second second
     * @return first - second
     */
    public Integer min(Integer first, Integer second) {
        return first - second;
    }

    /**
     * Find maximum of two numbers.
     * @param first first number
     * @param second second number
     * @return max
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Print sorted orders of all books.
     * @param books book
     */
    public void print(HashMap<Book, HashSet<Order>> books) {
        for (Book book : books.keySet()) {
            int max = max(book.getBuyBooks().size(), book.getSellBooks().size());
            ArrayList<Double> buyKey = new ArrayList<>();
            ArrayList<Integer> buyValue = new ArrayList<>();
            ArrayList<Double> sellKey = new ArrayList<>();
            ArrayList<Integer> sellValue = new ArrayList<>();
            buyKey.addAll(book.getBuyBooks().keySet());
            buyValue.addAll(book.getBuyBooks().values());
            sellKey.addAll(book.getSellBooks().keySet());
            sellValue.addAll(book.getSellBooks().values());
             addElement(buyKey, buyValue, max);
            addElement(sellKey, sellValue, max);
            System.out.println("Order book :" + book.getName());
            System.out.println("BID            ASK");
            System.out.println("Volume@Price – Volume@Price");
            for (int i = 0; i < max; i++) {
                System.out.println(String.format("%d@%.1f - %d@%.1f", buyValue.get(i), buyKey.get(i), sellValue.get(i), sellKey.get(i)));
            }
            System.out.println();

        }
    }

    /**
     * Fill collection where size less witch another.
     * @param keys keys
     * @param values values
     * @param max max
     */
    public void addElement(ArrayList<Double> keys, ArrayList<Integer> values, int max) {
        while (keys.size() != max) {
            keys.add(null);
            values.add(null);
        }
    }
}

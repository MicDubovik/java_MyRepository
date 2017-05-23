package ru.job4j.MyParserMap;

import java.util.*;

/**
 * OrderBook.
 */
public class OrderBook {
    /**
     * HashMap<Book, HashSet<Order>> books.
     */
    private HashMap<Book, HashSet<Order>> books;


    /**
     * Constructor.
     */
    public OrderBook() {
        this.books = new HashMap<>();
    }

    /**
     * Get.
     *
     * @return
     */
    public HashMap<Book, HashSet<Order>> getBooks() {
        return books;
    }

    /**
     * Set.
     *
     * @param books
     */
    public void setBooks(HashMap<Book, HashSet<Order>> books) {
        this.books = books;
    }

    /**
     * Add book.
     *
     * @param book
     * @param order
     */
    public void addBook(Book book, Order order) {

        books.get(book).add(order);
    }

    /**
     * Delete book.
     *
     * @param book
     * @param order
     */
    public void deleteBook(Book book, Order order) {
        books.get(book).remove(order);
    }

    /**
     * Sort order.
     *
     * @param buy
     * @param sel
     * @param order
     */
    public void sortOrder(Map<Double, Integer> buy, Map<Double, Integer> sel, Order order) {
        if (sel.containsKey(order.getPrice())) {
            if (sel.get(order.getPrice()) < order.getVolume()) {
                if (buy.containsKey(order.getPrice())) {
                    buy.put(order.getPrice(), (order.getVolume() - (sel.get(order.getPrice())) + buy.get(order.getPrice())));
                } else {
                    buy.put(order.getPrice(), (order.getVolume() - (sel.get(order.getPrice()))));
                }
                sel.remove(order.getPrice());
            } else if (sel.get(order.getPrice()) > order.getVolume()) {
                sel.put(order.getPrice(), (sel.get(order.getPrice()) - order.getVolume()));
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
     * Sort.
     *
     * @param orders
     */
    public void sort(HashMap<Book, HashSet<Order>> orders) {
        for (Book book : orders.keySet()) {
            Map<Double, Integer> buy = book.getBookBuy();
            Map<Double, Integer> sel = book.getBookSell();
            HashSet<Order> tmp = orders.get(book);
            for (Order order : tmp) {
                if (order.getOperation().equals("BUY")) {
                    sortOrder(buy, sel, order);
                } else {
                    sortOrder(sel, buy, order);
                }
            }
        }
    }

    /**
     * compareBidAsk.
     *
     * @param bidlist
     * @param asklist
     * @return
     */
    public List<SortedSet<Order>> compareBidAsk(Map<Double, Integer> bidlist, Map<Double, Integer> asklist) {

        Comparator comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else return 0;
            }
        };
        /**
         * Comparator for Buy lists.
         */
        Comparator comparator2 = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() > o2.getPrice()) {
                    return -1;
                } else return 0;
            }
        };

        SortedSet<Order> bid = new TreeSet<>(comparator);

        SortedSet<Order> ask = new TreeSet<>(comparator2);


        List<SortedSet<Order>> resultList = new ArrayList<>();


        for (Map.Entry<Double, Integer> temp : bidlist.entrySet()) {
            Order mybid = new Order();

            mybid.setPrice(temp.getKey());
            mybid.setVolume(temp.getValue());
            mybid.setOperation("str ");
            mybid.setOrderId(1);
            bid.add(mybid);

        }
        for (Map.Entry<Double, Integer> temp : asklist.entrySet()) {
            Order myask = new Order();
            myask.setPrice(temp.getKey());
            myask.setVolume(temp.getValue());
            ask.add(myask);
        }

        Iterator askiterator = ask.iterator();

        Iterator biditerator = bid.iterator();

        boolean flagBID = true;
        boolean flagASK = true;
        Order mybid = new Order();
        Order myask = new Order();
        while (askiterator.hasNext() && biditerator.hasNext()) {

            if (flagBID) {
                mybid = ((Order) biditerator.next());
            }
            if (flagASK)
                myask = ((Order) askiterator.next());

            if (mybid.getPrice() > myask.getPrice()) {
                if (mybid.getVolume() > myask.getVolume()) {

                    mybid.setVolume(mybid.getVolume() - myask.getVolume());
                    askiterator.remove();

                    flagBID = false;
                    flagASK = true;
                } else if (mybid.getVolume() < myask.getVolume()) {
                    myask.setVolume(myask.getVolume() - mybid.getVolume());

                    biditerator.remove();

                    flagASK = false;
                    flagBID = true;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        resultList.add(bid);
        resultList.add(ask);
        return resultList;
    }

    /**
     * print.
     * @param orders
     */
    public void print(HashMap<Book, HashSet<Order>> orders) {
        List<SortedSet<Order>> mapList = null;
        for (Book book : orders.keySet()) {
            System.out.println("Book name- " + book.getName());
            mapList = compareBidAsk(book.getBookBuy(), book.getBookSell());

            for (SortedSet<Order> orderSortedSet : mapList) {
                for (Order order : orderSortedSet) {
                    System.out.println("Orders- " + order.getOperation());
                    System.out.println(order);
                }

            }
            System.out.println();
        }
    }

    /**
     * Show.
     * @param orders
     */
    public void show(HashMap<Book, HashSet<Order>> orders) {
        for (Book book : orders.keySet()) {
            System.out.println("Book name- " + book.getName());
            for (Map.Entry<Double, Integer> dIEntry : book.getBookBuy().entrySet()) {
                System.out.println("Orders - BUY");
                System.out.println("Price-" + dIEntry.getKey() + ":  valume-" + dIEntry.getValue());
            }
            System.out.println();
            for (Map.Entry<Double, Integer> dIEntry2 : book.getBookSell().entrySet()) {
                System.out.println("Orders - SEll");
                System.out.println("Price-" + dIEntry2.getKey() + ":  valume-" + dIEntry2.getValue());
            }
            System.out.println();
        }
        System.out.println();
    }
}

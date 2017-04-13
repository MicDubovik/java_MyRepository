package ru.job4j.ParserXML;

import java.util.*;

/**
 * class for keep books.
 */
public class Book {
    /**
     * List for keep Sell books.
     */
    private ArrayList<MyList> askBook;
    /**
     * List for keep Buy books.
     */
    private ArrayList<MyList> bidBook;

    /**
     * Constructor.
     */
    public Book() {

        this.askBook = new ArrayList<>();
        this.bidBook = new ArrayList<>();
    }

    /**
     * Get ASKbook.
     * @return
     */
    public ArrayList<MyList> getAskBook() {
        return askBook;
    }

    /**
     * Get BIDbook.
     * @return
     */
    public ArrayList<MyList> getBidBook() {
        return bidBook;
    }

    /**
     * Sort Lists.
     */
    public void sortLists() {
        bidBook.sort(new Comparator<MyList>() {
            @Override
            public int compare(MyList o1, MyList o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() > o2.getPrice()) {
                    return -1;
                } else return 0;
            }
        });

        askBook.sort(new Comparator<MyList>() {
            @Override
            public int compare(MyList o1, MyList o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return -1;
                } else return 0;
            }
        });
    }
}



package ru.job4j.ParserXML;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class OrdersList {

   Comparator comparator = new Comparator<MyList>() {
        @Override
        public int compare(MyList o1, MyList o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() < o2.getPrice()) {
                return -1;
            } else return 0;
        }
    };

    Comparator comparator2 = new Comparator<MyList>() {
        @Override
        public int compare(MyList o1, MyList o2) {
            if (o1.getPrice() < o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() > o2.getPrice()) {
                return -1;
            } else return 0;
        }
    };

    private SortedSet<MyList> book1BID = new TreeSet<>(comparator2);
    private SortedSet<MyList> book2BID = new TreeSet<>(comparator2);
    private SortedSet<MyList> book3BID = new TreeSet<>(comparator2);

    private SortedSet<MyList> book1ASK = new TreeSet<>(comparator);
    private SortedSet<MyList> book2ASK = new TreeSet<>(comparator);
    private SortedSet<MyList> book3ASK = new TreeSet<>(comparator);


    private SortedSet<MyList> bookBID = new TreeSet<>(comparator2);
    private SortedSet<MyList> bookASK = new TreeSet<>(comparator);


    public SortedSet<MyList> getBookBID() {
        return bookBID;
    }

    public SortedSet<MyList> getBookASK() {
        return bookASK;
    }


    public SortedSet<MyList> getBook1BID() {
        return book1BID;
    }

    public void setBook1BID(SortedSet<MyList> book1BID) {
        this.book1BID = book1BID;
    }

    public SortedSet<MyList> getBook2BID() {
        return book2BID;
    }

    public void setBook2BID(SortedSet<MyList> book2BID) {
        this.book2BID = book2BID;
    }

    public SortedSet<MyList> getBook3BID() {
        return book3BID;
    }

    public void setBook3BID(SortedSet<MyList> book3BID) {
        this.book3BID = book3BID;
    }

    public SortedSet<MyList> getBook1ASK() {
        return book1ASK;
    }

    public void setBook1ASK(SortedSet<MyList> book1ASK) {
        this.book1ASK = book1ASK;
    }

    public SortedSet<MyList> getBook2ASK() {
        return book2ASK;
    }

    public void setBook2ASK(SortedSet<MyList> book2ASK) {
        this.book2ASK = book2ASK;
    }

    public SortedSet<MyList> getBook3ASK() {
        return book3ASK;
    }

    public void setBook3ASK(SortedSet<MyList> book3ASK) {
        this.book3ASK = book3ASK;
    }
}

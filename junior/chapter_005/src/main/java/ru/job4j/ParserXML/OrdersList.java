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

    private SortedSet<MyList> book1 = new TreeSet<>(comparator);
    private SortedSet<MyList> book2 = new TreeSet<>(comparator);
    private SortedSet<MyList> book3 = new TreeSet<>(comparator);


    private SortedSet<MyList> bookBID = new TreeSet<>(comparator2);
    private SortedSet<MyList> bookASK = new TreeSet<>(comparator);


    public SortedSet<MyList> getBookBID() {
        return bookBID;
    }

    public SortedSet<MyList> getBookASK() {
        return bookASK;
    }


    public SortedSet<MyList> getBook1() {
        return book1;
    }



    public SortedSet<MyList> getBook2() {
        return book2;
    }

    public void setBook2(SortedSet<MyList> book2) {
        this.book2 = book2;
    }

    public SortedSet<MyList> getBook3() {
        return book3;
    }

}

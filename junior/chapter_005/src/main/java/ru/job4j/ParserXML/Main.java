package ru.job4j.ParserXML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    /**
     * 2-nd reference on the ASK list from method compare.
     */
    SortedSet<MyList> myFinishAsk = new TreeSet<>();

    /**
     * Get List without DeleteOrder.
     *
     * @param addlist
     * @param deletelisr
     * @return
     */
    public List<MyList> listAfterDeleteFromOrder(List<MyList> addlist, List<MyDeleteList> deletelisr) {

        List<MyList> newlist = new LinkedList<>();
        List<MyList> newlistAfterDel = addlist;
        for (MyList aList : addlist) {
            for (MyDeleteList dList : deletelisr) {
                if (aList.getOrderId() == dList.getOrderId()) {
                    newlist.add(aList);
                }
            }
        }
        newlistAfterDel.removeAll(newlist);
        return newlistAfterDel;
    }

    /**
     * Get ListBID.
     *
     * @param addlist
     * @return
     */
    public List<MyList> listBID(List<MyList> addlist) {
        List<MyList> listBID = new LinkedList<>();
        for (MyList myList : addlist) {
            if (myList.getOperation().equals("BUY")) {
                listBID.add(myList);
            }
        }
        return listBID;
    }

    /**
     * Get ListASK.
     *
     * @param addlist
     * @return
     */
    public List<MyList> listASK(List<MyList> addlist) {
        List<MyList> listASK = new LinkedList<>();
        for (MyList myList : addlist) {
            if (myList.getOperation().equals("SELL")) {
                listASK.add(myList);
            }
        }
        return listASK;
    }

    /**
     * Get List without duplicate Order.Value - summ.
     *
     * @param list
     * @return
     */
    public SortedSet<MyList> listSumVolume(List<MyList> list) {

        List<MyList> listSumVolume = new LinkedList<>();
        SortedSet<MyList> newlistSumVolume = new TreeSet<>();

        listSumVolume.addAll(list);

        System.out.println();

        for (MyList myList : listSumVolume) {
            for (int i = 0; i < list.size(); i++) {
                double first = myList.getPrice();
                double second = list.get(i).getPrice();

                if (!myList.equals(list.get(i)) && first == second) {
                    myList.setValue(myList.getValue() + list.get(i).getValue());

                }
                newlistSumVolume.add(myList);
            }
        }
        return newlistSumVolume;
    }

    /**
     * Compare Order .
     * @param bidlist
     * @param asklist
     * @return
     */
    public SortedSet<MyList> compareBidAsk(SortedSet<MyList> bidlist, SortedSet<MyList> asklist) {
        /**
         * Iterator for BID list.
         */
        Iterator askiterator = asklist.iterator();
        /**
         * Iterator for ASK list.
         */
        Iterator biditerator = bidlist.iterator();
        /**
         * Flags for switch iterators.
         */
        boolean flagBID = true;
        boolean flagASK = true;
        /**
         * Variables for move iterators
         */
        MyList mybid = null;
        MyList myask = null;

        while (askiterator.hasNext() && biditerator.hasNext()) {

            if (flagBID) {
                mybid = ((MyList) biditerator.next());
            }
            if (flagASK)
                myask = ((MyList) askiterator.next());

            if (mybid.getPrice() > myask.getPrice()) {
                if (mybid.getValue() > myask.getValue()) {

                    mybid.setValue(mybid.getValue() - myask.getValue());
                    askiterator.remove();

                    flagBID = false;
                    flagASK = true;
                } else if (mybid.getValue() < myask.getValue()) {
                    myask.setValue(myask.getValue() - mybid.getValue());

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
        this.myFinishAsk = asklist;
        return bidlist;
    }

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

        long timerBegin = System.currentTimeMillis();

        /**
         * 3 list AddOrder for 3-th book .
         */

        List<MyList> addlist1 = new LinkedList<>();
        List<MyList> addlist2 = new LinkedList<>();
        List<MyList> addlist3 = new LinkedList<>();
        /**
         * 3 list DeleteOrder for 3-th book .
         */
        List<MyDeleteList> deleteLists1 = new LinkedList<>();
        List<MyDeleteList> deleteLists2 = new LinkedList<>();
        List<MyDeleteList> deleteLists3 = new LinkedList<>();
        /**
         * Create parser for XML.
         */
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        FileInputStream fis = new FileInputStream("\\Project\\orders.xml");

        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(fis);

        while (streamReader.getEventType() != XMLStreamConstants.END_DOCUMENT) {

            switch (streamReader.next()) {

                case XMLStreamConstants.START_ELEMENT: {

                    if (streamReader.getLocalName().toLowerCase().equals("addorder")) {

                        String book = streamReader.getAttributeValue(0);
                        String operation = streamReader.getAttributeValue(1);
                        double price = Double.parseDouble(streamReader.getAttributeValue(2));
                        int volume = Integer.parseInt(streamReader.getAttributeValue(3));
                        int orderId = Integer.parseInt(streamReader.getAttributeValue(4));

                        if (book.equals("book-1")) {
                            MyList myList1 = new MyList(book, operation, price, volume, orderId);
                            addlist1.add(myList1);
                        } else if (book.equals("book-2")) {
                            MyList myList2 = new MyList(book, operation, price, volume, orderId);
                            addlist2.add(myList2);
                        } else {
                            MyList myList3 = new MyList(book, operation, price, volume, orderId);
                            addlist3.add(myList3);
                        }

                    } else if (streamReader.getLocalName().toLowerCase().equals("deleteorder")) {

                        String book = streamReader.getAttributeValue(0);
                        int orderId = Integer.parseInt(streamReader.getAttributeValue(1));

                        if (book.equals("book-1")) {

                            MyDeleteList myDeleteList = new MyDeleteList(book, orderId);
                            deleteLists1.add(myDeleteList);

                        } else if (book.equals("book-2")) {

                            MyDeleteList myDeleteList2 = new MyDeleteList(book, orderId);
                            deleteLists2.add(myDeleteList2);

                        } else {
                            MyDeleteList myDeleteList3 = new MyDeleteList(book, orderId);
                            deleteLists3.add(myDeleteList3);
                        }

                    }
                }
            }
        }

////        for (MyList myList : addlist1) {
////            System.out.println(myList);
////        }
////        System.out.println("-----------------------------------------------------------------------");
////
////        for (MyDeleteList deleteList : deleteLists1) {
////            System.out.println(deleteList);
////        }
//
//        Main main = new Main();
//
//        List<MyList> newlist = main.listAfterDeleteFromOrder(addlist1, deleteLists1);
//
////        System.out.println("------------------------------------------------------------------------");
////
////        for (MyList myList : newlist) {
////            System.out.println(myList);
////        }
////        System.out.println("------------------------------------------------------------------------");
//
//        List<MyList> bidList = main.listBID(newlist);
//
////        for (MyList myList : bidList) {
////            System.out.println(myList);
////        }
////        System.out.println("------------------------------------------------------------------------");
//
//        List<MyList> askList = main.listASK(newlist);
////        for (MyList myList : askList) {
////            System.out.println(myList);
////        }
////        System.out.println("------------------------------------------------------------------------");
//
//        SortedSet<MyList> sortedAsk = main.listSumVolume(askList);
////        for (MyList myList : sortedAsk) {
////            System.out.println(myList);
////        }
////        System.out.println("------------------------------------------------------------------------");
//
//        SortedSet<MyList> sortedBID = main.listSumVolume(bidList);
////
////        for (MyList myList : sortedBID) {
////            System.out.println(myList);
////        }
////        System.out.println("------------------------------------------------------------------------");
//
//        SortedSet<MyList> sortedBid = new TreeSet<MyList>(new Comparator<MyList>() {
//            @Override
//            public int compare(MyList o1, MyList o2) {
//                if (o1.getPrice() < o2.getPrice()) {
//                    return 1;
//                } else if (o1.getPrice() > o2.getPrice()) {
//                    return -1;
//                } else return 0;
//            }
//        });
//
//
//        sortedBid.addAll(sortedBID);
//
////        for (MyList myList : sortedBid) {
////            System.out.println(myList);
////        }
////        System.out.println("------------------------------------------------------------------------");
//
//        SortedSet<MyList> lastListBID = main.compareBidAsk(sortedBid, sortedAsk);
//        System.out.println("My lastListBID");
//        for (MyList myList : lastListBID) {
//            System.out.println(myList);
//        }
//
//        System.out.println("------------------------------------------------------------------------");
//        System.out.println("My last listASK");
//        for (MyList myList : main.myFinishAsk) {
//            System.out.println(myList);
//        }
//        System.out.println("------------------------------------------------------------------------");

        long timeerEnd = System.currentTimeMillis();
        System.out.println(timeerEnd-timerBegin);
    }
}
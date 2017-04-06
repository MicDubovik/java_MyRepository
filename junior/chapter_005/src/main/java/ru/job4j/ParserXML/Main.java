package ru.job4j.ParserXML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.FileNotFoundException;
=======
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
>>>>>>> Update
import java.util.*;

public class Main {


    /**
     * 2-nd reference on the ASK list from method compare.
     */
    SortedSet<MyList> myFinishAsk = new TreeSet<>();

//    TreeMap<String,Order> ordersAdd = new TreeMap<>();
//    TreeMap<String,Order> ordersDel = new TreeMap<>();
///
//
//    List<MyList> addlist1 = new LinkedList<>();
//    List<MyList> addlist2 = new LinkedList<>();
//    List<MyList> addlist3 = new LinkedList<>();
//    /**
//     * 3 list DeleteOrder for 3-th book .
//     */
//    List<MyDeleteList> deleteLists1 = new LinkedList<>();
//    List<MyDeleteList> deleteLists2 = new LinkedList<>();
//    List<MyDeleteList> deleteLists3 = new LinkedList<>();

    Order order = new Order();
    /**
     * 2-nd reference on the ASK list from method compare.
     */
    SortedSet<MyList> myFinishAsk1 = new TreeSet<>();
    SortedSet<MyList> myFinishAsk2 = new TreeSet<>();
    SortedSet<MyList> myFinishAsk3 = new TreeSet<>();

    public void parse(FileReader fr) throws FileNotFoundException, XMLStreamException {

        /**
         * Create parser for XML.
         */
//        FileReader fileReader = new FileReader(fileName);

//        XMLInputFactory factory = XMLInputFactory.newInstance();
//        XMLStreamReader reader = factory.createXMLStreamReader(fileReader);


        XMLInputFactory inputFactory = XMLInputFactory.newInstance();


        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(fr);


        while (streamReader.getEventType() != XMLStreamConstants.END_DOCUMENT) {


                switch (streamReader.next()) {

                    case XMLStreamConstants.START_ELEMENT: {

                        MyList myList = null;

                        if (streamReader.getLocalName().toLowerCase().equals("addorder")) {
                            String name = "addorder";
                            String book = streamReader.getAttributeValue(0);
                            String operation = streamReader.getAttributeValue(1);
                            double price = Double.parseDouble(streamReader.getAttributeValue(2));
                            int volume = Integer.parseInt(streamReader.getAttributeValue(3));
                            int orderId = Integer.parseInt(streamReader.getAttributeValue(4));


                            if (book.equals("book-1")) {
                                myList = new MyList(name, book, operation, price, volume, orderId);

                            } else if (book.equals("book-2")) {
                                myList = new MyList(name, book, operation, price, volume, orderId);

                            } else {
                                myList = new MyList(name, book, operation, price, volume, orderId);

                            }
//


//                            if (operation.equals("BUY")){

                                order.addListSetOrder(myList);
//                            } else {
//                                order.delListSetOrder(myList);
//                            }


                        } else if (streamReader.getLocalName().toLowerCase().equals("deleteorder")) {
//
                            int orderId = Integer.parseInt(streamReader.getAttributeValue(1));
//
//                        order.ordersAdd.remove(orderId);
                            myList = new MyList(orderId);
                            order.delListSetOrder(myList);
                        }
//
                    }
                }
        }
    }

    /**
     * Get List without DeleteOrder.№2
     */
    public void listDeleteOrderDel() {

    }


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


//        Iterator itAdd = addlist.listIterator();
//        Iterator itDEl = deletelisr.listIterator();
//        MyList admy = null;
//        MyList delmy = null;
//        while (itDEl.hasNext()) {
//            admy = (MyList) itAdd.next();
//            delmy = (MyList) itDEl.next();
//            if (admy.getOrderId() == (delmy.getOrderId())) {
//                itAdd.remove();
//                itDEl.remove();
//            } else {
//
//            }
//
//        }


//        addlist.get().getOrderId();
/**
 * First realisation.
 */
//      List<MyList> newlist = new LinkedList<>();
        List<MyList> newlistAfterDel = addlist;
//        for (MyList aList : addlist) {
//            for (MyDeleteList dList : deletelisr) {
//                if (aList.getOrderId() == dList.getOrderId()) {
//                    newlist.add(aList);
//                }
//            }
//        }
//        newlistAfterDel.removeAll(newlist);
        return newlistAfterDel;
//    }

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

        if (myask.getBook().equals("book-1")) {
            this.myFinishAsk1 = asklist;
        } else if (myask.getBook().equals("book-2")) {
            this.myFinishAsk2 = asklist;
        } else {
            this.myFinishAsk3 = asklist;
        }


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


        Main main = new Main();

        long starttimerParse = System.currentTimeMillis();
        System.out.println("Start parse");
        String fileName = String.format(
                "%s%s%s", System.getProperty("java.io.tmpdir"), File.separator, "orders.xml");
        String fileName2 = "\\Project\\test.xml";
        FileReader fileReader = new FileReader(fileName2);
        main.parse(fileReader);
        long endtimerParse = System.currentTimeMillis();
        System.out.println("End parse, time is - " + (endtimerParse - starttimerParse));

        for (MyList myList : main.order.listSet) {
            System.out.println(myList);
        }
        System.out.println("---------------");

        main.order.sort(main.order.listSet);

        for (MyList myList : main.order.ordersBID) {
            System.out.println(myList);
        }
        System.out.println("---------------");
        for (MyList myList : main.order.ordersASK) {
            System.out.println(myList);
        }
//        main.order.summValue(main.order.ordersBID);
//        System.out.println("---------------");
//        for (MyList myList : main.order.ordersBID) {
//            System.out.println(myList);
//        }


//        for (Map.Entry<Integer, MyList> item : main.order.ordersAdd.entrySet()) {
//            System.out.printf("Ключ: %s  Значение: %s \n", item.getKey(), item.getValue().getName());
//        }

//        System.out.println("Start Delete order from list");
//        long starttimerDeleteOrders  = System.currentTimeMillis();
//        List<MyList> newlist1 = main.listAfterDeleteFromOrder(main.addlist1, main.deleteLists1);
//        List<MyList> newlist2 = main.listAfterDeleteFromOrder(main.addlist2, main.deleteLists2);
//        List<MyList> newlist3 = main.listAfterDeleteFromOrder(main.addlist3, main.deleteLists3);
//        long endtimerDeleteOrders  = System.currentTimeMillis();
//        System.out.println("End time Delete order from list = "+(endtimerDeleteOrders-starttimerDeleteOrders));
//
//        System.out.println("Start create BIDorder  list");
//        long starttimerCreateBID  = System.currentTimeMillis();
//        List<MyList> bidList1 = main.listBID(newlist1);
//        List<MyList> bidList2 = main.listBID(newlist2);
//        List<MyList> bidList3 = main.listBID(newlist3);
//        long endtimerCreateBID  = System.currentTimeMillis();
//        System.out.println("End time create BIDorder list = "+(endtimerCreateBID-starttimerCreateBID));
//
//        System.out.println("Start create ASKorder  list");
//        long starttimerCreateASK  = System.currentTimeMillis();
//        List<MyList> askList1 = main.listASK(newlist3);
//        List<MyList> askList2 = main.listASK(newlist3);
//        List<MyList> askList3 = main.listASK(newlist3);
//        long endtimerCreateASK  = System.currentTimeMillis();
//        System.out.println("End time create ASKorder list = "+(endtimerCreateASK-starttimerCreateASK));
//
//        System.out.println("Start ListSumVolumeBID ");
//        long starttimerListVolumeBID  = System.currentTimeMillis();
//        SortedSet<MyList> sortedBID1 = main.listSumVolume(bidList1);
//        SortedSet<MyList> sortedBID2 = main.listSumVolume(bidList2);
//        SortedSet<MyList> sortedBID3 = main.listSumVolume(bidList3);
//        long endtimerListVolumeBID  = System.currentTimeMillis();
//        System.out.println("End time ListSumVolumeBID = "+(endtimerListVolumeBID-starttimerListVolumeBID));
//
//        System.out.println("Start ListSumVolumeASK ");
//        long starttimerListVolumeASK  = System.currentTimeMillis();
//        SortedSet<MyList> sortedAsk1 = main.listSumVolume(askList1);
//        SortedSet<MyList> sortedAsk2 = main.listSumVolume(askList2);
//        SortedSet<MyList> sortedAsk3 = main.listSumVolume(askList3);
//        long endtimerListVolumeASK= System.currentTimeMillis();
//        System.out.println("End time ListSumVolumeASK = "+(endtimerListVolumeASK-starttimerListVolumeASK));
//
//        Comparator<MyList> comparator = new Comparator<MyList>() {
//            @Override
//            public int compare(MyList o1, MyList o2) {
//                if (o1.getPrice() < o2.getPrice()) {
//                    return 1;
//                } else if (o1.getPrice() > o2.getPrice()) {
//                    return -1;
//                } else return 0;
//            }
//        };

//        SortedSet<MyList> sortedBid1 = new TreeSet<MyList>(comparator);
//        SortedSet<MyList> sortedBid2 = new TreeSet<MyList>(comparator);
//        SortedSet<MyList> sortedBid3 = new TreeSet<MyList>(comparator);
//
//        System.out.println("Start sortedBID ");
//        long starttimerSortedBID  = System.currentTimeMillis();
//        sortedBid1.addAll(sortedBID1);
//        sortedBid2.addAll(sortedBID2);
//        sortedBid3.addAll(sortedBID3);
//        long endtimerSortedBID = System.currentTimeMillis();
//        System.out.println("End time ListSumVolumeBID = "+(endtimerSortedBID-starttimerSortedBID));
//
//        System.out.println("Start create finish orders  ");
//        long starttimerfinish  = System.currentTimeMillis();
//        SortedSet<MyList> lastListBID1 = main.compareBidAsk(sortedBid1, sortedAsk1);
//        SortedSet<MyList> lastListBID2 = main.compareBidAsk(sortedBid2, sortedAsk2);
//        SortedSet<MyList> lastListBID3 = main.compareBidAsk(sortedBid3, sortedAsk3);
//        long endtimerfinish = System.currentTimeMillis();
//        System.out.println("End time create finish orders  = "+(endtimerfinish-starttimerfinish));
//        System.out.println("-----------------------------------------------------------");
//        System.out.println("Full time    = "+(endtimerfinish-starttimerParse));


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
////       System.out.println("------------------------------------------------------------------------");


        long timeerEnd = System.currentTimeMillis();
        System.out.println(timeerEnd-timerBegin);
 
    }
}
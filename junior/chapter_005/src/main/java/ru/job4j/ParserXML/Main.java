package ru.job4j.ParserXML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {


    Order order = new Order();
    /**
     * 2-nd reference on the ASK list from method compare.
     */


    public void parse(FileReader fr) throws FileNotFoundException, XMLStreamException {

        /**
         * Create parser for XML.
         */


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
                                order.addListMapOrder(myList.getOrderId(),myList);
//                                order.addListSetOrder(myList);

                        } else if (streamReader.getLocalName().toLowerCase().equals("deleteorder")) {

                            int orderId = Integer.parseInt(streamReader.getAttributeValue(1));

//                            myList = new MyList(orderId);
                            order.delListMapOrder(orderId);
//                            order.delListSetOrder(myList);
                        }

                    }
                }
        }
    }





    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {


        long timerBegin = System.currentTimeMillis();

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

//        for (MyList myList : main.order.listSet) {
//            System.out.println(myList);
//        }
        System.out.println("---------------");

        main.order.sort(main.order.listMap);

        main.order.cutListBID(main.order.ordersBID);
        main.order.cutListASK(main.order.ordersASK);

        System.out.println("BOOK-1,bid");
        main.order.compareBidAsk(main.order.getOrdersList().getBook1BID(),main.order.getOrdersList().getBook1ASK());
        for (MyList myList : main.order.getOrdersList().getBookBID()) {
            System.out.println(myList);
        }
        System.out.println("-----");
        System.out.println("ask");
        for (MyList myList : main.order.getOrdersList().getBookASK()) {
            System.out.println(myList);
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("BOOK-2,bid");
        main.order.compareBidAsk(main.order.getOrdersList().getBook1BID(),main.order.getOrdersList().getBook1ASK());
        for (MyList myList : main.order.getOrdersList().getBookBID()) {
            System.out.println(myList);
        }
        System.out.println("-----");
        System.out.println("ask");
        for (MyList myList : main.order.getOrdersList().getBookASK()) {
            System.out.println(myList);
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("BOOK-3,bid");
        main.order.compareBidAsk(main.order.getOrdersList().getBook1BID(),main.order.getOrdersList().getBook1ASK());
        for (MyList myList : main.order.getOrdersList().getBookBID()) {
            System.out.println(myList);
        }
        System.out.println("-----");
        System.out.println("ask");
        for (MyList myList : main.order.getOrdersList().getBookASK()) {
            System.out.println(myList);
        }
//        for (MyList myList : main.order.ordersBID) {
//            System.out.println(myList);
//        }
//        System.out.println("---------------");
//        for (MyList myList : main.order.ordersASK) {
//            System.out.println(myList);
//        }
//        System.out.println("---------------");

//        main.order.compareBidAsk(main.order.ordersBID,main.order.ordersASK);

//        for (MyList myList : main.order.ordersBID) {
//            System.out.println(myList);
//        }
//
//        System.out.println("---------------");
//        for (MyList myList : main.order.ordersASK) {
//            System.out.println(myList);
//        }

        long timeerEnd = System.currentTimeMillis();
        System.out.println(timeerEnd-timerBegin);
 
    }
}
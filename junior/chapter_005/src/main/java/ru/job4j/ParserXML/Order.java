package ru.job4j.ParserXML;

import java.util.*;

public class Order {
    /**
     *Reference on OrderList.
     */
    private OrdersList ordersList = new OrdersList();
    /**
     * Map for keep Integer-orderID and objects Mylist.
     * Using for fast find orderID.
     */
    Map<Integer, MyList> listMap = new HashMap<>();

//    SortedSet<MyList> listSet = new TreeSet<>(new Comparator<MyList>() {
//        @Override
//        public int compare(MyList o1, MyList o2) {
//            if (o1.getPrice() > o2.getPrice()) {
//                return 1;
//            } else if (o1.getPrice() < o2.getPrice()) {
//                return -1;
//            } else return 0;
//        }
//    });

    /**
     * Constructor.
     */
    public Order() {
    }

    /**
     * List for keeping orders BUY.
     */
    SortedSet<MyList> ordersBID = new TreeSet<>(new Comparator<MyList>() {
        @Override
        public int compare(MyList o1, MyList o2) {
            if (o1.getPrice() < o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() > o2.getPrice()) {
                return -1;
            } else return 0;
        }
    });
    /**
     * List for keeping orders Sell.
     */
    SortedSet<MyList> ordersASK = new TreeSet<>(new Comparator<MyList>() {
        @Override
        public int compare(MyList o1, MyList o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() < o2.getPrice()) {
                return -1;
            } else return 0;
        }
    });


    /**
     * Method for add elements on MapList.
     * @param id
     * @param myList
     */
    public void addListMapOrder(Integer id, MyList myList) {
        listMap.put(id, myList);

    }

    /**
     * Method for delete elements on MapList.
     * @param id
     */
    public void delListMapOrder(Integer id) {

        listMap.remove(id);
    }

    /**
     * Reserve methods add and delete.
     * @param listMap
     */
//    public void addListSetOrder(MyList myList) {
//        MyList add = null;
//        for (MyList list : listSet) {
//            double first = list.getPrice();
//            double second = myList.getPrice();
//            if (first == second) {
//
//                add = list;
//                add.setValue(list.getValue() + myList.getValue());
//                break;
//            }
//        }
//        listSet.add(myList);
//    }
//
//
//    public void delListSetOrder(MyList myList) {
//        MyList del = null;
//        for (MyList list : listSet) {
//            int first = list.getOrderId();
//            int second = myList.getOrderId();
//            if (first == second) {
//                del = list;
//                break;
//            }
//        }
//        listSet.remove(del);
//    }

    /**
     * Method for cut Map on Buy and Sell lists, sort lists and sum value lists with equal price.
     * @param listMap
     */
    public void sort(Map<Integer, MyList> listMap) {

        for (MyList list : listMap.values()) {

            if (list.getOperation().equals("BUY")) {

                for (MyList myList1 : ordersBID) {
                    double first = list.getPrice();
                    double second = myList1.getPrice();
                    if (first == second) {
                        myList1.setValue(myList1.getValue() + list.getValue());
                    }
                }
                this.ordersBID.add(list);
            } else if (list.getOperation().equals("SELL")) {
                for (MyList myList1 : ordersASK) {
                    double first = list.getPrice();
                    double second = myList1.getPrice();
                    if (first == second) {
                        myList1.setValue(myList1.getValue() + list.getValue());
                    }
                }
                this.ordersASK.add(list);
            }
        }

    }

    /**
     * Method for cut listBuy on book1,book2,book3.
     * @param listSet
     */
    public void cutListBID(SortedSet<MyList> listSet) {

        for (MyList list : listSet) {

            String nameBookList = list.getBook();

            if (nameBookList.equals("book-1")) {

                ordersList.getBook1BID().add(list);

            } else if (nameBookList.equals("book-2")) {


                ordersList.getBook2BID().add(list);

            } else {

                ordersList.getBook3BID().add(list);
            }

        }

    }

    /**
     * Method for cut listSell on book1,book2,book3.
     * @param listSet
     */
    public void cutListASK(SortedSet<MyList> listSet) {

        for (MyList list : listSet) {

            String nameBookList = list.getBook();

            if (nameBookList.equals("book-1")) {

                ordersList.getBook1ASK().add(list);

            } else if (nameBookList.equals("book-2")) {


                ordersList.getBook2ASK().add(list);

            } else {

                ordersList.getBook3ASK().add(list);
            }

        }

    }

    /**
     * Method for compare Buy and Sell lists , and delete unusable deal.
     * @param bidlist
     * @param asklist
     */
    public void compareBidAsk(SortedSet<MyList> bidlist, SortedSet<MyList> asklist) {
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

        ordersList.getBookASK().clear();
        ordersList.getBookBID().clear();



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

        ordersList.getBookBID().addAll(bidlist);
        ordersList.getBookASK().addAll(asklist);
    }

    /**
     * Properties for OrderList.
     * @return
     */
    public OrdersList getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(OrdersList ordersList) {
        this.ordersList = ordersList;
    }
}
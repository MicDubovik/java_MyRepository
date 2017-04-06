package ru.job4j.ParserXML;

import java.util.*;

public class Order {

    private String name;
    private MyList myList;
    private OrdersList ordersList = new OrdersList();

    Map<Integer, MyList> listMap = new HashMap<>();

    SortedSet<MyList> listSet = new TreeSet<>(new Comparator<MyList>() {
        @Override
        public int compare(MyList o1, MyList o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() < o2.getPrice()) {
                return -1;
            } else return 0;
        }
    });


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

    SortedSet<MyList> ordersASK = new TreeSet<>(new Comparator<MyList>() {
        @Override
        public int compare(MyList o1, MyList o2) {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() < o2.getPrice()) {
                return -1;
            } else return 0;
        }
    }); //


    public Order() {
    }

    public void addListMapOrder(Integer id, MyList myList) {
        listMap.put(id, myList);

    }

    public void delListMapOrder(Integer id) {

        listMap.remove(id);
    }


    public void addListSetOrder(MyList myList) {
        MyList add = null;
        for (MyList list : listSet) {
            double first = list.getPrice();
            double second = myList.getPrice();
            if (first == second) {

                add = list;
                add.setValue(list.getValue() + myList.getValue());
                break;
            }
        }
        listSet.add(myList);
    }


    public void delListSetOrder(MyList myList) {
        MyList del = null;
        for (MyList list : listSet) {
            int first = list.getOrderId();
            int second = myList.getOrderId();
            if (first == second) {
                del = list;
                break;
            }
        }
        listSet.remove(del);
    }

    public void sort(Map<Integer, MyList> listMap) {

        for (MyList list : listMap.values()) {

            if (list.getOperation().equals("BUY")) {
                this.ordersBID.add(list);

            }
            else if(list.getOperation().equals("SELL")) {
                this.ordersASK.add(list);

            }
        }
    }

    public void cutList(SortedSet<MyList> listSet) {

        for (MyList list : listSet) {

            String nameBookList = list.getBook();

            if (nameBookList.equals("book-1")) {
                for (MyList myList1 : ordersList.getBook1()) {
                    if (myList1.getPrice()==list.getPrice()){
                        list.setValue(myList1.getValue()+list.getValue());
                    }
                }
                ordersList.getBook1().add(list);

            } else if (nameBookList.equals("book-2")) {
                for (MyList myList1 : ordersList.getBook2()) {
                    if (myList1.getPrice()==list.getPrice()){
                        list.setValue(myList1.getValue()+list.getValue());
                    }
                }
                ordersList.getBook2().add(list);

            } else {
                for (MyList myList1 : ordersList.getBook3()) {
                    if (myList1.getPrice()==list.getPrice()){
                        list.setValue(myList1.getValue()+list.getValue());
                    }
                }
                ordersList.getBook3().add(list);
            }

        }

    }


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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyList getMyList() {
        return myList;
    }

    public void setMyList(MyList myList) {
        this.myList = myList;
    }

    public OrdersList getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(OrdersList ordersList) {
        this.ordersList = ordersList;
    }
}

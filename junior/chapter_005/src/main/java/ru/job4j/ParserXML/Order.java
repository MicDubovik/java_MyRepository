package ru.job4j.ParserXML;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Order {

    private String name;
    private MyList myList;

    SortedSet<MyList> listSet = new TreeSet<>(  new Comparator<MyList>() {
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

    public void addListSetOrder(MyList myList) {
        MyList add = null;
        for (MyList list : listSet) {
            double first = list.getPrice();
            double second = myList.getPrice();
            if (first==second){

                add=list;
                add.setValue(list.getValue()+myList.getValue());break;


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

<<<<<<< HEAD
    public void cutList(SortedSet<MyList> listSet) {
        SortedSet<MyList> book1 = new TreeSet<>();
        SortedSet<MyList> book2 = new TreeSet<>();
        SortedSet<MyList> book3 = new TreeSet<>();

=======
    public void cutList(SortedSet<MyList> listSet){
>>>>>>> parent of 32c8f0f... up

        for (MyList list : listSet) {

            String nameBookList = list.getBook();
<<<<<<< HEAD
            if (nameBookList.equals("book-1")) {

                book1.add(list);
                ordersList.ordersListObj.addlist(book1);
                book1.add(list);
            } else if (nameBookList.equals("book-2")){
                book2.add(list);
                ordersList.ordersListObj.addlist(book2);
                book2.add(list);
            } else {
                book3.add(list);
                ordersList.ordersListObj.addlist(book3);
=======
            if (nameBookList.equals("book-1")){
                new SortedSet<>()
>>>>>>> parent of 32c8f0f... up
            }

        }

    }


    public void sort(SortedSet<MyList> listsort) {

        Iterator it = listsort.iterator();
        MyList myList = null;
        boolean flag = true;

        while (it.hasNext()) {

//
                myList = (MyList) it.next();
//                if (myList.getPrice() == myList.next().getPrice() && myList.getOperation().equals(myList.next().getOperation())) {
//                    myList.setValue(myList.getValue() + myList.next().getValue());
                    if (myList.getOperation().equals("BUY")) {
                        this.ordersBID.add(myList);

                    }
                    if (myList.getOperation().equals("SELL")) {
                        this.ordersASK.add(myList);

                    }
                }
            }

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
        if (myask.getBook().equals("book-1")) {
            this.myFinishAsk1 = asklist;
        } else if (myask.getBook().equals("book-2")) {
            this.myFinishAsk2 = asklist;
        } else {
            this.myFinishAsk3 = asklist;
        }

        return bidlist;
    }




//    public void summValue(SortedSet<MyList> list) {
//
//        Iterator it = list.iterator();
//        MyList myList = null;
//        boolean flag = true;
//
//        while (it.hasNext()) {
//            if (flag) {
//                myList = (MyList) it.next();
//                if (myList.getPrice() == myList.next().getPrice()) {
//                    myList.setValue(myList.getValue() + myList.next().getValue());
//                    myList.next().remove();
//                }
//            }
//        }
//    }

//    public void listSumVolume(SortedSet<MyList> list) {
//
//        SortedSet<MyList> listSumVolume = new TreeSet<>();
//        SortedSet<MyList> newlistSumVolume = new TreeSet<>();
//
//        listSumVolume.addAll(list);
//
//        System.out.println();
//
//        for (MyList myList : listSumVolume) {
//            for (MyList myList2 : list) {
//                double first = myList.getPrice();
//                double second = myList2.getPrice();
//
//                if (!myList.equals(myList2) && first == second) {
//                    myList.setValue(myList.getValue() + myList2.getValue());
//                    this.ordersBID.add(myList);
//                } else {
//
//                }
//
//            }
//        }
//
//    }
//    public void cutList(Set<MyList> listSet){
//        if (listSet.contains())
//    }
//    public void addOdrer(Integer name, MyList list) {
//        ordersAdd.put(name, list);
//    }
//
//
//    public void deleteOrder(String name, MyList list) {
//        ordersDel.remove(name, list);
//    }


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

}

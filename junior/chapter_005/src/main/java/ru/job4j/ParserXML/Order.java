package ru.job4j.ParserXML;

import java.util.*;

public class Order {
    /**
     * Map for keep books by name.
     */
    private Map<String, Book> books = new HashMap<>();

    /**
     * Constructor.
     */
    public Order() {

    }

    /**
     * Method for create books  .
     * @param listMap
     */
    public void createBooks(Map<Integer, MyList> listMap) {

        for (Map.Entry<Integer, MyList> tmp : listMap.entrySet()) {
            if (!books.containsKey(tmp.getValue().getBook())) {
                books.put(tmp.getValue().getBook(), new Book());
                if (tmp.getValue().getOperation().equals("BUY")) {
                    books.get(tmp.getValue().getBook()).getBidBook().add(tmp.getValue());
                } else {
                    books.get(tmp.getValue().getBook()).getAskBook().add(tmp.getValue());
                }
            } else {
                if (tmp.getValue().getOperation().equals("BUY")) {
                    books.get(tmp.getValue().getBook()).getBidBook().add(tmp.getValue());
                } else {
                    books.get(tmp.getValue().getBook()).getAskBook().add(tmp.getValue());
                }

            }
        }
    }

    /**
     * Method sum volume in list with same price.
     */
    public void sumPrice(){
        for (Map.Entry<String, Book> tmp : books.entrySet()) {
            sum(tmp.getValue().getBidBook());
            sum(tmp.getValue().getAskBook());
        }
    }

    /**
     * Implement method sum.
     * @param list
     */
    public void sum(ArrayList<MyList> list){

        for (int i = 0; i < list.size(); i++) {
        MyList temp =list.get(i);
        double price1 = list.get(i).getPrice();
            for (int j = i+1; j <list.size() ; j++) {
                double price2 =list.get(j).getPrice();
               if (price1==price2){
                    temp.setValue(temp.getValue()+list.get(j).getValue()) ;
                   list.remove(j);
                   j--;
               }
            }
        }
    }

    /**
     * Method sort lists and cut book  for compare.
     */
    public void cutList() {
        for (Map.Entry<String, Book> stringBookEntry : books.entrySet()) {
            stringBookEntry.getValue().sortLists();
        }

        for (Book book : books.values()) {
            compareBidAsk(book.getBidBook(),book.getAskBook());
        }

    }

    /**
     * Method for compare Buy and Sell lists , and delete unusable deal.
     *
     * @param bidlist
     * @param asklist
     */
    public void compareBidAsk(ArrayList<MyList> bidlist, ArrayList<MyList> asklist) {


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

    }

    /**
     * Get for books.
     * @return
     */

    public Map<String, Book> getBooks() {
        return books;
    }

}
package ru.job4j.ParserXML;


import java.util.Iterator;

/**
 * Class for my Order.
 */
public class MyList   implements Iterator{
    /**
     * Name.
     */
    private String name;
    /**
     * Book.
     */
    private String book;
    /**
     * Operation.
     */
    private String operation;
    /**
     * Price.
     */
    private double price;
    /**
     * Value.
     */
    private int value;
    /**
     * OrderId.
     */
    private int orderId;
    /**
     * Reference on next element.
     */
    private MyList next;

    /**
     * Constructor.
     * @param name
     * @param book
     * @param operation
     * @param price
     * @param value
     * @param orderId
     */
    public MyList(String name ,String book, String operation, double price, int value, int orderId) {
        this.name =  name;
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.value = value;
        this.orderId = orderId;
    }

    /**
     * Second constructor.
     * @param orderId
     */
    public MyList( int orderId) {
        this.book = book;
        this.orderId = orderId;
    }

    /**
     * Properties for all fields.
     * @return
     */
    public MyList getMyList() {
        return next;
    }

    public void setMyList(MyList myList) {
        this.next = myList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getName() {
        return name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * Override method toString.
     * @return
     */
    @Override
    public String toString() {
        return "AddOrder{" +
                "book='" + book + '\'' +
                ", operation='" + operation + '\'' +
                ", price=" + price +
                ", value=" + value +
                ", orderId=" + orderId +
                '}';
    }

    /**
     * Implement iterator.
     * @return
     */
    @Override
    public boolean hasNext() {
        if (next.next() != null)
            return true;
        else return false;
    }

    /**
     * Implement iterator.
     * @return
     */
    @Override
    public MyList next() {

        return next;
    }

    /**
     * Override equals.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyList myList = (MyList) o;

        if (Double.compare(myList.price, price) != 0) return false;
        if (value != myList.value) return false;
        if (orderId != myList.orderId) return false;
        if (name != null ? !name.equals(myList.name) : myList.name != null) return false;
        if (book != null ? !book.equals(myList.book) : myList.book != null) return false;
        return operation != null ? operation.equals(myList.operation) : myList.operation == null;
    }

    /**
     * Override hashCode.
     * @return
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + value;
        result = 31 * result + orderId;
        return result;
    }
}

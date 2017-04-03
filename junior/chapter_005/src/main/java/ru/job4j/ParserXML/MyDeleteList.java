package ru.job4j.ParserXML;

public class MyDeleteList {

    private static final String name="DeleteOrder";
    private String book;
    private int orderId;

    public MyDeleteList(String book, int orderId) {
        this.book = book;
        this.orderId = orderId;
    }

    public static String getName() {
        return name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "DeleteOrder{" +
                "book='" + book + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}

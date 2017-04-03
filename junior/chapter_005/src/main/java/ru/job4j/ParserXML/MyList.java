package ru.job4j.ParserXML;

public class MyList implements Comparable<MyList>{

    private static  final String name="AddOrder";
    private String book;
    private String operation;
    private Double price;
    private int value;
    private int orderId;

    public MyList(String book, String operation, Double price, int value, int orderId) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.value = value;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

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

    @Override
    public int compareTo(MyList o) {
        return this.price.compareTo(o.getPrice());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyList myList = (MyList) o;

        if (value != myList.value) return false;
        if (orderId != myList.orderId) return false;
        if (book != null ? !book.equals(myList.book) : myList.book != null) return false;
        if (operation != null ? !operation.equals(myList.operation) : myList.operation != null) return false;
        return price != null ? price.equals(myList.price) : myList.price == null;
    }

    @Override
    public int hashCode() {
        int result = book != null ? book.hashCode() : 0;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + value;
        result = 31 * result + orderId;
        return result;
    }
}

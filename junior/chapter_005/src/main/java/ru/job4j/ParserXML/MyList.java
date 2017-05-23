package ru.job4j.ParserXML;


/**
 * Class for my Order.
 */
public class MyList  {

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
     * Constructor.
     * @param book
     * @param operation
     * @param price
     * @param value
     * @param orderId
     */
    public MyList(String book, String operation, double price, int value, int orderId) {

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
     * Get.
     * @return
     */
    public String getBook() {
        return book;
    }
    /**
     * Get.
     * @return
     */
    public String getOperation() {
        return operation;
    }
    /**
     * Get.
     * @return
     */
    public double getPrice() {
        return price;
    }
    /**
     * Get.
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Set.
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * Get.
     * @return
     */
    public int getOrderId() {
        return orderId;
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
     * Override equals method.
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
        if (book != null ? !book.equals(myList.book) : myList.book != null) return false;
        return operation != null ? operation.equals(myList.operation) : myList.operation == null;
    }

    /**
     * Override hashcode method.
     * @return
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = book != null ? book.hashCode() : 0;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + value;
        result = 31 * result + orderId;
        return result;
    }

}

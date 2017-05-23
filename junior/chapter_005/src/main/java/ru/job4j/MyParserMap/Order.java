package ru.job4j.MyParserMap;

/**
 * Order.
 */
public class Order {
    /**
     * operation.
     */
    private String operation;
    /**
     * price.
     */
    private double price;
    /**
     * volume.
     */
    private int volume;
    /**
     * orderId.
     */
    private int orderId;

    /**
     * Constructor.
     * @param operation
     * @param price
     * @param volume
     * @param orderId
     */
    public Order(String operation, double price, int volume, int orderId) {
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
    }

    /**
     * Constructor.
     * @param orderId
     */
    public Order(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Constructor.
     */
    public Order() {
    }

    /**
     * Get.
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set.
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Get.
     * @return
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Set.
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
    /**
     * Get.
     * @return
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Set.
     * @param operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
    /**
     * Get.
     * @return
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set.
     * @param orderId
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * equals.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (Double.compare(order.price, price) != 0) return false;
        if (volume != order.volume) return false;
        if (orderId != order.orderId) return false;
        return operation != null ? operation.equals(order.operation) : order.operation == null;
    }

    /**
     * hashCode.
     * @return
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = operation != null ? operation.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + volume;
        result = 31 * result + orderId;
        return result;
    }

    /**
     * toString.
     * @return
     */
    @Override
    public String toString() {
        return "Order{" +
                "operation='" + operation + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }
}

package ru.job4j.MyParserMap;

public class Order {

    private String operation;

    private double price;

    private int volume;

    private int orderId;


    public Order(String operation, double price, int volume, int orderId) {
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
    }

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public Order() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

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

    @Override
    public String toString() {
        return "Order{" +
                "operation='" + operation + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }
}

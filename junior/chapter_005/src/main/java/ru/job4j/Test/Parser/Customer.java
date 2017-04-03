package ru.job4j.Test.Parser;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "Orders")
public class Customer {

    private String AddOrder;
    private String book;
    private double orderId;
    private  double price;
    private String operation;

    public String getAddOrder() {
        return AddOrder;
    }
    @XmlElement
    public void setAddOrder(String addOrder) {
        AddOrder = addOrder;
    }

    public String getBook() {
        return book;
    }
    @XmlAttribute
    public void setBook(String book) {
        this.book = book;
    }

    public double getOrderId() {
        return orderId;
    }
    @XmlAttribute
    public void setOrderId(double orderId) {
        this.orderId = orderId;
    }

    public String getOperation() {
        return operation;
    }
    @XmlAttribute
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getPrice() {
        return price;
    }
    @XmlAttribute
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "AddOrder='" + AddOrder + '\'' +
                ", book='" + book + '\'' +
                ", orderId=" + orderId +
                ", price=" + price +
                ", operation='" + operation + '\'' +
                '}';
    }
}

package ru.job4j.Test.Parser;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Orders")
public class AddOrder {

//    private String book;
//    private String operation;
    private  double price;
    private double volume;
    private double orderId;

    public double getVolume() {
        return volume;
    }
    @XmlAttribute
    public void setVolume(double volume) {
        this.volume = volume;
    }

//    public String getBook() {
//        return book;
//    }
//    @XmlAttribute
//    public void setBook(String book) {
//        this.book = book;
//    }

    public double getOrderId() {
        return orderId;
    }
    @XmlAttribute
    public void setOrderId(double orderId) {
        this.orderId = orderId;
    }

//    public String getOperation() {
//        return operation;
//    }
//    @XmlAttribute
//    public void setOperation(String operation) {
//        this.operation = operation;
//    }

    public double getPrice() {
        return price;
    }
    @XmlAttribute
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AddOrder{" +
                "  "+
                ", book='" +   + '\'' +
                ", orderId=" + orderId +
                ", price=" + price +
                ", operation='" +   + '\'' +
                '}';
    }
}


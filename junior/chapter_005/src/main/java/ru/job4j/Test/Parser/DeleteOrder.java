package ru.job4j.Test.Parser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Orders")
public class DeleteOrder {

    private String book;
    private double orderId;

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
}

package ru.job4j.Test.Parser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Orders")
public class Orders {

    @XmlElement(name = "AddOrder")
    List<AddOrder> addOrderList = new ArrayList<>();
//    @XmlElement(name = "DeleteOrder")
//    List<DeleteOrder> deleteOrderList = new ArrayList<>();

    public Orders() {
    }

//    public List<AddOrder> getAddOrderList() {
//        return addOrderList;
//    }

    public void setAddOrderList(List<AddOrder> addOrderList) {
        this.addOrderList = addOrderList;
    }

//    public List<DeleteOrder> getDeleteOrderList() {
//        return deleteOrderList;
//    }
//
//    public void setDeleteOrderList(List<DeleteOrder> deleteOrderList) {
//        this.deleteOrderList = deleteOrderList;
//    }
}








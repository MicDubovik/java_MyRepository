package ru.job4j.Test.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class MyJaxb {

    public static void main(String[] args) throws JAXBException {

//        Subscriber sub1 = new Subscriber("sachin","tendulkar", "postpaid");
//        Subscriber sub2 = new Subscriber("pawan","kalyan", "postpaid");
//        Subscriber sub3 = new Subscriber("sree","nath", "prepaid");

        List<AddOrder> addOrderList = new ArrayList<AddOrder>();

//        subscribers.add(sub1);
//        subscribers.add(sub2);
//        subscribers.add(sub3);

        //Call marshall method to convert java objects to XML.
//        System.out.println("Marshalling : Converting java object's into XML ........ ");
//        String xml= marshall(addOrderList, Orders.class);
//        System.out.println(xml);


        //Call Unmarshal method to convert XML to java object's.
        String xml = "/Project/Test.xml";
        System.out.println("UnMarshalling : Converting XML to java objects. ........ ");
        Object obj= unmarshall(Orders.class,xml);
        System.out.println(obj);

    }


//    public static String marshall(List<Subscriber> subscribers, Class objectClass) throws JAXBException{
//
//        // create JAXB context and initializing Marshaller
//        JAXBContext jaxbCtxt = JAXBContext.newInstance(objectClass);
//        Marshaller jaxbMarshaller = jaxbCtxt.createMarshaller();
//
//        // for getting nice formatted output
//        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//        StringWriter stringWriterObj = new StringWriter();
//
//        // Converting java object to xml using JAXB marshal API
//        jaxbMarshaller.marshal(new Subscribers(subscribers), stringWriterObj);
//        String xmlString = stringWriterObj.toString();
//
//        return xmlString;
//
//    }

    public static Object unmarshall(Class objectClass, String xml) throws JAXBException{


        Orders orders = new Orders();
        AddOrder addOrder = new AddOrder();
        // Creating an Unmarshaller
        JAXBContext jaxbCtxt = JAXBContext.newInstance(objectClass);
        Unmarshaller jaxbUnmarshaller = jaxbCtxt.createUnmarshaller();
        StringReader sr = new StringReader(xml);

        //Converting XML to java object using JAXB unmarshal API.
        addOrder = (AddOrder) jaxbUnmarshaller.unmarshal(sr);

        return addOrder;

    }
}


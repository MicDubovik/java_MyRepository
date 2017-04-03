package ru.job4j.Test.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JAXBExample {

    public static void main(String[] args) {
        try {
            File file = new File(  "/Project/Test.xml");
            JAXBContext context = JAXBContext.newInstance(Orders.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AddOrder addOrder = (AddOrder) unmarshaller.unmarshal(file);
            System.out.println(addOrder);
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBExample.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}

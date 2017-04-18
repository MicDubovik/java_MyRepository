package ru.job4j.PetrXmlParse;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * TODO: comment
 * @author parsentev
 * @since 24.10.2015
 */
public class StAXLLoader {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream in = new FileInputStream("\\Project\\orders.xml");
        XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                if ("AddOrder".equals(startElement.getName().getLocalPart())) {

                }
            }
        }
        System.out.println(String.format("time : %s s", (System.currentTimeMillis() - start)));
    }
}

package ru.job4j.ParserXML;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Parse {



    Map<Integer, MyList> listMap = new HashMap<>();

    /**
     * StreamParser for XML.
     *
     * @param fr
     * @throws FileNotFoundException
     * @throws XMLStreamException
     */

    public void parse(FileReader fr) throws FileNotFoundException, XMLStreamException {

        /**
         * Create parser for XML.
         */


        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        XMLStreamReader streamReader = inputFactory.createXMLStreamReader(fr);

        while (streamReader.getEventType() != XMLStreamConstants.END_DOCUMENT) {

            switch (streamReader.next()) {

                case XMLStreamConstants.START_ELEMENT: {

                    if (streamReader.getLocalName().equals("AddOrder")) {


                        String book = streamReader.getAttributeValue(0);
                        String operation = streamReader.getAttributeValue(1);
                        double price = Double.parseDouble(streamReader.getAttributeValue(2));
                        int volume = Integer.parseInt(streamReader.getAttributeValue(3));
                        int orderId = Integer.parseInt(streamReader.getAttributeValue(4));

                        listMap.put(orderId, new MyList(book, operation, price, volume, orderId));

                    } else if (streamReader.getLocalName().equals("DeleteOrder")) {

                        int orderId = Integer.parseInt(streamReader.getAttributeValue(1));

                        listMap.remove(orderId);


                    }
                }
            }
        }
    }

}

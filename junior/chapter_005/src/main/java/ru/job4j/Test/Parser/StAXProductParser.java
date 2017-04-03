package ru.job4j.Test.Parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXProductParser extends ProductParser {

    ParserEnum parserEnum = new ParserEnum();



// реализация абстрактного метода из суперкласса для разбора потока

    public void parse(InputStream input) {

        XMLInputFactory inputFactory =

                XMLInputFactory.newInstance();

        try {

            XMLStreamReader reader =

                    inputFactory.createXMLStreamReader(input);

            process(reader);

        } catch (XMLStreamException e) {

            e.printStackTrace();

        }

    }

// метод, управляющий разбором потока

    public void process(XMLStreamReader reader)

            throws XMLStreamException {

        String name;

        while (reader.hasNext()) {

// определение типа "прочтённого" элемента (тега)

            int type = reader.next();

            switch (type) {

                case XMLStreamConstants.START_ELEMENT:

                    name = reader.getLocalName();

                    switch (name.toLowerCase()) {

                        case "orders":

                            writeTitle();



                            break;

                        case "addorder":



                            System.out.println(reader.getAttributeLocalName(0));
                            System.out.println(reader.getAttributeName( 0));
                            System.out.println(reader.getAttributeValue(name,name.toLowerCase()));
                            System.out.println(reader.getElementText());
                            break;

                        case "deleteorder":

                            writeSubcategoryStart(reader.getAttributeValue(null,

                                    "DeleteOrder"));

                            break;

//                        case PRODUCT:
//
//                            writeProductStart();
//
//                            break;

                        default:

//                            writeProductFeatureStart(name);

                            break;

                    }

                    break;

                case XMLStreamConstants.END_ELEMENT:

                    name = reader.getLocalName();

                    switch ( name.toLowerCase()) {

                        case "addorder":

                            writeCategoryEnd();

                            break;

                        case "deleteorder":

                            writeSubcategoryEnd();

                            break;

//                        case PRODUCT:
//
//                            writeProductEnd();
//
//                            break;

                        default:

                            writeProductFeatureEnd();

                            break;

                    }

                    break;

                case XMLStreamConstants.CHARACTERS:

                    writeText(reader.getText());

                    break;

                default:

                    break;

            }

        }

    }

}

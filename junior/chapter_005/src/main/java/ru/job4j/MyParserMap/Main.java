package ru.job4j.MyParserMap;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {



        String fileName = String.format(
                "%s%s%s", System.getProperty("java.io.tmpdir"), File.separator, "orders.xml");

        String fileName2 = "\\Project\\test.xml";

        FileReader fileReader = new FileReader(fileName);

        OrderBook orderBook = new OrderBook();

        Parser parser = new Parser(orderBook);

        long starttimerParse = System.currentTimeMillis();

        parser.parse(fileName);

        long endtimerParse = System.currentTimeMillis();
        System.out.println("End parse, time is - " + (endtimerParse - starttimerParse));

        orderBook.sort(orderBook.getBooks());
        orderBook.print(orderBook.getBooks());
//        orderBook.show(orderBook.getBooks());
        long timeend = System.currentTimeMillis();
        System.out.println(endtimerParse - starttimerParse);
    }
}

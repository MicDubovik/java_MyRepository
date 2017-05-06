package ru.job4j.ParserMap;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Start of program.
 */
public class Start {
    /**
     * Enter point.
     * @param args args
     * @throws FileNotFoundException ex
     * @throws XMLStreamException ex
     */
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        String fileIn = String.format(
                "%s%s%s", System.getProperty("java.io.tmpdir"), File.separator, "orders.xml");
        OrderBook orderBook = new OrderBook();
        Parser parser = new Parser(orderBook);

        long timeMill = System.currentTimeMillis();
        parser.parse(fileIn);
        long timeEndPars = System.currentTimeMillis();
        orderBook.sort(orderBook.getBooks());
        orderBook.print(orderBook.getBooks());
        long time = System.currentTimeMillis();
        System.out.println(timeEndPars - timeMill);
    }
}

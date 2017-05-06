package ru.job4j.ParserMap;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Parser of xml.
 */
public class Parser {
    /**
     * HashMap of book and books"name for parsing.
     */
    private HashMap<String, Book> bookName;
    /**
     * OrderBook for tranfser added data.
     */
    private OrderBook orderBook;

    /**
     * Constructor.
     * @param orderBook orderbook
     */
    public Parser(OrderBook orderBook) {
        this.orderBook = orderBook;
        this.bookName = new HashMap<>();
    }

    /**
     * Getter for bookName.
     * @return bookName
     */
    public HashMap<String, Book> getBookName() {
        return bookName;
    }

    /**
     * Parse file.
     * @param fileName filename
     * @throws XMLStreamException ex
     * @throws FileNotFoundException ex
     */
    public void parse(String fileName) throws XMLStreamException, FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(fileReader);

        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                if ("AddOrder".equals(reader.getLocalName())) {
                    String name = reader.getAttributeValue(0);
                    if (!bookName.containsKey(name)) {
                        bookName.put(name, new Book(name));
                        orderBook.getBooks().put(bookName.get(name), new HashSet<Order>());
                    }
                    String action = reader.getAttributeValue(1);
                    Double price = Double.parseDouble(reader.getAttributeValue(2));
                    int volume = Integer.parseInt(reader.getAttributeValue(3));
                    int id = Integer.parseInt(reader.getAttributeValue(4));
                    orderBook.addBook(bookName.get(name), new Order(action, price, volume, id));
                }
                if ("DeleteOrder".equals(reader.getLocalName())) {
                    String name = reader.getAttributeValue(0);
                    int id = Integer.parseInt(reader.getAttributeValue(1));
                    orderBook.deleteBook(bookName.get(name), new Order(id));
                }
            }
        }
    }
}

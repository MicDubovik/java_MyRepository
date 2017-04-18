package ru.job4j.ParserXML;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {


    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {


        Parse parse = new Parse();
        Order order = new Order();

        long starttimerParse = System.currentTimeMillis();

        System.out.println("Start parse");

        String fileName = String.format(
                "%s%s%s", System.getProperty("java.io.tmpdir"), File.separator, "orders.xml");

        String fileName2 = "\\Project\\test.xml";

        FileReader fileReader = new FileReader(fileName);

        long timerBegin = System.currentTimeMillis();
        parse.parse(fileReader);
        long endtimerParse = System.currentTimeMillis();
        System.out.println("End parse, time is - " + (endtimerParse - timerBegin));
        System.out.println("-----------------------------------------------------------------------------");

        order.createBooks(parse.listMap);
        order.sumPrice();
        order.cutList();

        System.out.println("-----------------------------------------------------------------------------");

        for (Book book : order.getBooks().values()) {
            System.out.println(book.getBidBook().get(0).getBook());
            System.out.println(book.getBidBook().get(0).getOperation());
            for (MyList myList : book.getBidBook()) {
                System.out.println(myList);
            }
            System.out.println();
            System.out.println(book.getAskBook().get(0).getOperation());
            for (MyList myList : book.getAskBook()) {
                System.out.println(myList);
            }
            System.out.println("------------------------------------------------------------");
        }

        System.out.println("------------------------------------------------------------");
        long timeerEnd = System.currentTimeMillis();
        System.out.println(timeerEnd -timerBegin);

    }


}


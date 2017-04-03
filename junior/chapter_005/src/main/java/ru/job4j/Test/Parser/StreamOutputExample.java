package ru.job4j.Test.Parser;

import java.io.FileInputStream;
import java.io.InputStream;

public class StreamOutputExample {

    public static void main(String[] args) throws Exception {

        ProductParser parser = new StAXProductParser();

// создание входного потока данных из xml-файла

        InputStream input =

                new FileInputStream("\\Project\\Test.xml");

// разбор файла с выводом результата на консоль

        parser.parse(input);

    }

}

package ru.job4j.Test.Parser;

import java.io.InputStream;

public abstract class ProductParser {

    public abstract void parse(InputStream input);

    public void writeTitle() {

        System.out.println("Orders:");

    }

//    public void writeCategoryStart(String name) {
//
//        System.out.println("AddOrder: " + name.trim());
//
//    }

    public void writeCategoryEnd() {

        System.out.println();

    }

    public void writeSubcategoryStart(String name) {

        System.out.println("DeleteOrder: " + name.trim());

    }

    public void writeSubcategoryEnd() {

        System.out.println();

    }

    public void writeProductStart() {

        System.out.println(" Product Start ");

    }

    public void writeProductEnd() {

        System.out.println(" Product End ");

    }

//    public void writeProductFeatureStart(String name) {
//
//        switch (ParserEnum.valueOf(name.toUpperCase())) {
//
//            case PRODUCER:
//
//                System.out.print("Provider: ");
//
//                break;
//
//            case MODEL:
//
//                System.out.print("Model: ");
//
//                break;
//
//            case YEAR:
//
//                System.out.print("Date of issue: ");
//
//                break;
//
//            case COLOR:
//
//                System.out.print("Color: ");
//
//                break;
//
//            case NOTAVAILABLE:
//
//                System.out.print("Not available");
//
//                break;
//
//            case COST:
//
//                System.out.print("Cost: ");
//
//                break;
//
//        }
//
//    }

    public void writeProductFeatureEnd() {

        System.out.println();

    }

    public void writeText(String text) {

        System.out.print(text.trim());

    }

}

 






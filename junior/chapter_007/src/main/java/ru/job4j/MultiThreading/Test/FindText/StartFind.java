package ru.job4j.MultiThreading.Test.FindText;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Katy on 02.05.2017.
 */
public class StartFind {

    /**
     * StartFind constructor.
     * @throws InterruptedException exception.
     */
    private StartFind(String s) throws InterruptedException {
        Result result = new Result();
        System.out.println("Start find!");

        String text = "Лечение";
        text = text.substring(1, text.length() - 1).replaceAll(",", "");

        File path = new File("D:/");
        for (File file : path.listFiles()) {
            if (!result.isResult() && !file.getName().equals("$RECYCLE.BIN")) {
                Thread thread = new Thread(new Find(text, result, file));
                thread.start();
                thread.join();
            } else {
                break;
            }
        }
        System.out.println("Finish find!");
    }

    /**
     * Main.
     * @param args text for search.
     * @exception InterruptedException exception.
     */
    public static void main(String[] args) throws InterruptedException {
        new StartFind("hello");
    }
}

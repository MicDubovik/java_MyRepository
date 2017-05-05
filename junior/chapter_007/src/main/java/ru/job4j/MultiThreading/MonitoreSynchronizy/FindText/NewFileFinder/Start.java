package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.NewFileFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Katy on 03.05.2017.
 */
public class Start {

    String tempDirectory;
    String text;

    public void execute() {
        System.out.println("-----Welcome to FileFinder-------");
        System.out.println("Enter disk partition for search: ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            tempDirectory = scanner.next();
        }
        String directory = tempDirectory + ":\\";
        System.out.printf("Directory %s \n", directory);
        System.out.println("Enter text for search: ");


        if (scanner.hasNext()) {
            text = scanner.next();
        }

        String finalText = text;
        System.out.printf("Start searching .\n Please wait ... \n");
    }

    public static void main(String[] args) {


        Start start = new Start();

        start.execute();

        Buffer buffer = new Buffer(new ReentrantLock());

        MyFinder finder = new MyFinder(start.tempDirectory, buffer);


        try {
            finder.finderFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            finder.reader();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread one = new Thread(finder);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            threads.add(new Thread(new Checker(start.text, buffer)));
        }

        one.start();




        for (Thread thread : threads) {

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!buffer.it)
            System.out.println("File not found !");
    }
}
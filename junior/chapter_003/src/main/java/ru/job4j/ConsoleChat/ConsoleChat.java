package ru.job4j.ConsoleChat;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Katy on 11.03.2017.
 */
public class ConsoleChat {


    int ch ;
    BufferedReader brfile;
    StringBuilder sb ;
    Random random = new Random();
    String ask;

    /**
     * Читаем строки из файла и записываем в созданную строку.
     * @throws IOException
     */
    public void start() throws IOException {

        brfile = new BufferedReader(new FileReader("/TestDir/testdir2/file2.txt"));
        sb = new StringBuilder();



        while ((ch = brfile.read()) != -1) {

            sb.append((char) ch);

        }
    }

    /**
     * Метод чтения инфо с консоли
     * @throws IOException
     */

    public void read() throws IOException {

        Scanner sc = new Scanner(System.in);

        ask = sc.nextLine();
    }

    /**
     * Выбираем произвольные символы и выводим на экран.
     * @throws IOException
     */

    public void cont() throws IOException {


        int length = random.nextInt(4) + 3;
        int start = random.nextInt(sb.length() - length);
        System.out.println(sb.substring(start, start + length));


    }



    public static void main(String[] args) throws IOException {

        ConsoleChat chat = new ConsoleChat();

        chat.start();
        boolean stop = true;

        chat.read();
        while (!chat.ask.equals("end")) {

              if (chat.ask.equals("con")) {
                stop = true;
                chat.cont();
                chat.read();
            }
           else if (chat.ask.equals("stop") || !stop ) {
                stop = false;
                chat.read();

            }
              else {
                chat.cont();
                chat.read();
            }
        }
    }

}







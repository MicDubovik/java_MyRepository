package ru.job4j.ConsoleChat;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Katy on 11.03.2017.
 */
public class ConsoleChat {


    private String ask;
    static final String CON = "con";
    static final String STOP = "stop";
    static final String END = "end";
    StringBuilder sb;

    /**
     * Читаем строки из файла и записываем в созданную строку.
     *
     * @throws IOException
     */
    public void start() throws IOException {

        try (BufferedReader brfile = new BufferedReader(new FileReader("/TestDir/testdir2/file2.txt"))) {

            sb = new StringBuilder();
            int ch;

            while ((ch = brfile.read()) != -1) {

                sb.append((char) ch);

            }
        }

    }

    /**
     * Метод чтения инфо с консоли
     *
     * @throws IOException
     */

    public void read() throws IOException {

        Scanner sc = new Scanner(System.in);

        ask = sc.nextLine();
    }

    /**
     * Выбираем произвольные символы и выводим на экран.
     *
     * @throws IOException
     */

    public void cont() throws IOException {

        Random random = new Random();
        int length = random.nextInt(4) + 3;
        int start = random.nextInt(sb.length() - length);
        System.out.println(sb.substring(start, start + length));
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    /**
     * Cycle for work app. .
     * @throws IOException
     */

    public void cycle() throws IOException {
        boolean stop = true;
        while (!END.equals(this.ask)) {

            if (CON.equals(this.ask)) {
                stop = true;
                cont();
                read();
            } else if (STOP.equals(this.ask) || !stop) {
                stop = false;
                this.read();

            } else {
                cont();
                read();
            }
        }

    }


    public static void main(String[] args) throws IOException {

        ConsoleChat chat = new ConsoleChat();

        chat.start();
        chat.read();
        chat.cycle();

    }

}







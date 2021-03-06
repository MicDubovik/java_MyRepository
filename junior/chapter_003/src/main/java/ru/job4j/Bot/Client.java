package ru.job4j.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client.
 */
public class Client {
    /**
     * startClient.
     * @throws IOException
     */
    public void startClient() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 5000);
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner console = new Scanner(System.in)) {

            String str;

            do {

                String answer = console.nextLine();
                if ("by".equals(answer)) {
                    out.println(answer);
                    break;
                }
                out.println(answer);
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {

        Client cli = new Client();

        cli.startClient();
    }
}

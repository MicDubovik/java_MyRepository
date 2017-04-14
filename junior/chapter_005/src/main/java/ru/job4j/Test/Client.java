package ru.job4j.Test;

import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Socket client.
 * @author antonviktorov
 * @since 1.0
 */
public class Client {
    /**
     * Port number.
     */
    int port;
    /**
     * Current host.
     */
    String host;

    /**
     * Client constructor.
     */
    public Client() {
        this.port = 8080;
        this.host = "127.0.0.1";
    }

    /**
     * Connecting to server.
     */
    public void connect() {
        try {
            Socket socket = new Socket(InetAddress.getByName(this.host), this.port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);
            String str;
            out.println("Hello oracle");
            do {
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
                str = console.nextLine();
                out.println(str);
            } while (!str.equals("exit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Console function.
     * @param params - console params
     */
    public static void main(String[] params) {
        Client server = new Client();
        server.connect();
    }
}

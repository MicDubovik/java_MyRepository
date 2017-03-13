package ru.job4j.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Server {
    private Socket socket;
    private final int port = 5000;
    private final String[] asks = {"Hello", "By", "exit", "sure", "necessarily", "possible"};

    public Server(Socket socket) {
        this.socket = socket;
    }

    public String selectAsk(String[] asks) {
        Random random = new Random(5);
        return asks[random.nextInt()];
    }

    public void startServer() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String ask;

            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if (ask.equals("by")){
                    out.println("By");
                    out.println();
                }
               else if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                }
                 else  {
                    out.println(selectAsk(asks));
                    out.println();
                }
            } while ("by".equals(ask));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




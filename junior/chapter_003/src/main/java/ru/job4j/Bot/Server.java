package ru.job4j.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Server.
 */
public class Server {
    /**
     * Socket.
     */
    private Socket socket;
    /**
     * Array asks.
     */
    private final String[] asks = {"Hello", "I'm fine ", "ok!", "sure", "necessarily", "possible"};

    /**
     * selectAsk.
     * @param asks
     * @return
     */
    public String selectAsk(String[] asks) {
        Random random = new Random();
        return asks[random.nextInt(asks.length)];
    }
    /**
     * startServer.
     * @throws IOException
     */
    public void startServer() throws IOException {
        ServerSocket server = new ServerSocket(5000);
        Socket socket = server.accept();

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String ask;

            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                } else if (!("by".equals(ask))){
                    out.println(selectAsk(asks));
                    out.println();
                }
            } while (!"by".equals(ask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {

        Server serv =new Server();
        serv.startServer();

    }
}





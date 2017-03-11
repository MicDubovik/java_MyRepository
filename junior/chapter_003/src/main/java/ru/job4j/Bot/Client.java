package ru.job4j.Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

   private Socket socket;
   private int port ;


    public Client(Socket socket) {
        this.socket = socket;
    }



    public void startClient(){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);

            String ask = console.nextLine();
            do {
                if (ask.equals("By")){
                    break;
                }
                out.println(ask);
                String str ;
                while (!(str = in.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {

        int port = 5000;
        String ip = "127.0.0.1";
        Socket socket = new Socket(InetAddress.getByName(ip), port);

    }
}

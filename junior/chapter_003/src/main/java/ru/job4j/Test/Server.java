package ru.job4j.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(3000);
        Socket accept = server.accept();

        System.out.println("Server conected");

        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        DataInputStream in = new DataInputStream(inputStream);
        DataOutputStream out = new DataOutputStream(outputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String string;
        while (true) {

            string = in.readUTF();
            System.out.println("We get message = "+string);

            System.out.println("Send message back");
            out.writeUTF(string);
            out.flush();

        }


    }
}
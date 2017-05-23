package ru.job4j.Test;

import java.io.*;
import java.net.Socket;

/**
 * Client.
 */
public class Client {
    /**
     * main.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 3000);

        InputStream socketIn = socket.getInputStream();
        OutputStream socketOut = socket.getOutputStream();

        DataInputStream in = new DataInputStream(socketIn);
        DataOutputStream out = new DataOutputStream(socketOut);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream outputStream = new BufferedOutputStream(new BufferedOutputStream(System.out));

        String str = null;
        String str2 = null;
        while (true) {
            str = bufferedReader.readLine();
            out.writeUTF(str);
            str2 = in.readUTF();
            System.out.println("We get message back: "+str2);

        }
    }
}

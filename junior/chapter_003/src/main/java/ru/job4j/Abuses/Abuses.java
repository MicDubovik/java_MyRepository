package ru.job4j.Abuses;

import java.io.*;

/**
 * Created by Katy on 09.03.2017.
 */
public class Abuses {

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String result = null;


        for (String s : abuse) {

            result = result+sb.append(s.replaceAll("abuses", ""));

            br.read(s.toCharArray());

        }

        out.write(result.getBytes());

    }



}

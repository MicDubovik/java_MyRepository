package ru.job4j.Abuses;

import java.io.*;

/**
 * Created by Katy on 09.03.2017.
 */
public class Abuses {

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str=null;
        for (String s : abuse) {

            br.read(s.toCharArray());

              str = s.replaceAll("abuses", "");
        }

        out.write(str.getBytes());

    }

}

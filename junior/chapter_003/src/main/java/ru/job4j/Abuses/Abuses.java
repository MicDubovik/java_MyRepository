package ru.job4j.Abuses;

import java.io.*;

/**
 * Created by Katy on 09.03.2017.
 */
public class Abuses {

    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            StringBuilder sb = new StringBuilder();
            for (String s : abuse) {
                sb.append(s);
                sb.append(" ");
            }
            String str;
            while ((str = br.readLine()) != null) {
                str = str.replaceAll("abuse", "");
                bw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

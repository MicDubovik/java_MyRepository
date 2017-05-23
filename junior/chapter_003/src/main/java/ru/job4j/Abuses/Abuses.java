package ru.job4j.Abuses;

import java.io.*;

/**
 * Abuses.
 */
public class Abuses {
    /**
     * Drop.
     * @param in
     * @param out
     * @param abuse
     * @throws IOException
     */
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

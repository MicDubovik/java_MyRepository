package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText;

import java.io.File;
import java.util.concurrent.Callable;

public class FindFiles implements Callable<File> {
    /**
     * Text for find in fileName.
     */
    String text;
    /**
     * Input path.
     */
    File file;
    /**
     * Temp result for recursion method addFiles.
     */
    File result;

    /**
     * Constructor.
     *
     * @param text
     * @param file
     */
    public FindFiles(String text, File file) {
        this.text = text;
        this.file = file;
    }
    // Если понадобится перебор по дискам.
    /**
     * Array contain name path a-z.
     *
     * @param num
     * @return
     */
    public char isAvaliblePath(int num) {

        char[] arrayPath = new char[26];

        char alpha = 'a';
        for (char i = 0; i < 26; i++) {
            arrayPath[i] = alpha++;
        }

        char pathName = arrayPath[num];

        return pathName;
    }

    /**
     * Method find and compare file with text.
     *
     * @param fileIn
     * @return
     */
    public File addFiles(File fileIn) {

        if (result == null) {
            for (File file1 : fileIn.listFiles()) {

                if (file1.getName().indexOf(text) < 0 && !file1.getName().equals("$RECYCLE.BIN")) {
                    if (file1.isDirectory()) {

                        addFiles(file1);

                    }
                } else if (file1.getName().equals("$RECYCLE.BIN")) {


                } else {
                    result = file1;
                }
            }
        }

        return result;
    }


    @Override
    public File call() throws Exception {
        return addFiles(file);
    }


    public static void main(String[] args) {
        // Однопоточный режим.
        String text = "FindFiles";

        File file = new File("d:/");

        FindFiles files = new FindFiles(text, file);
        long start = System.currentTimeMillis();
        File temp = files.addFiles(file);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(temp.getAbsolutePath());

    }

}






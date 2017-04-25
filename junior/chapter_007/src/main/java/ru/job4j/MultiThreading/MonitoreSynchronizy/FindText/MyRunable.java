package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MyRunable implements Callable {

    private List<File> findFiles;

    private String text;

    private File result;

    private File temp;

      int  num = 0;

    boolean flag = false;

    public MyRunable(String text ) {
        this.text = text;
        this.findFiles = new ArrayList<>();
    }

    public List<File> getFindFiles() {
        return findFiles;
    }

    public void setFindFiles(List<File> findFiles) {
        this.findFiles = findFiles;
    }

    public File getTemp() {
        return temp;
    }

    public File getResult() {
        return result;
    }

    public synchronized int getNum() {
        return num;
    }

    public synchronized void setNum(int num) {
        this.num = num;
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
//                    while (!Thread.currentThread().isInterrupted()) {

                if (file1.getName().indexOf(text) < 0) {

                    if (file1.isDirectory()) {

                        addFiles(file1);

                    }
                } else if (file1.getName().equals("$RECYCLE.BIN")) {


                } else if (file1.getName().indexOf(text) >= 0) {
                    result = file1;
                    flag = true;
                    Thread.currentThread().interrupt();
                }
            }
        }
//        }

        return result;
    }

    @Override
    public File call() {

        File x = addFiles(findFiles.get(this.num));
//        if (x == null) {
//            x = new File("d:/");
//        }
        return x;
    }
}

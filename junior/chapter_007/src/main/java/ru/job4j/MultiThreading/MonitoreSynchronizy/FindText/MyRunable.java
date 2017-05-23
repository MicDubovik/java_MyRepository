package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * MyRunable
 */
public class MyRunable implements Callable<File>, Runnable {
    /**
     * List<File>.
     */
    private List<File> findFiles;
    /**
     * text.
     */
    private String text;
    /**
     * result.
     */
    private File result;
    /**
     * temp field.
     */
    private File temp;
    /**
     * num.
     */
    private int num = 0;
    /**
     * boolean flag.
     */
    volatile boolean flag = false;

    /**
     * Constructor.
     * @param text
     */
    public MyRunable(String text) {
        this.text = text;
        this.findFiles = new ArrayList<>();
    }

    /**
     * Get.
     * @return
     */
    public List<File> getFindFiles() {
        return findFiles;
    }

    /**
     * Set.
     * @param findFiles
     */
    public void setFindFiles(List<File> findFiles) {
        this.findFiles = findFiles;
    }
    /**
     * Get.
     * @return
     */
    public File getTemp() {
        return temp;
    }
    /**
     * Get.
     * @return
     */
    public File getResult() {
        return result;
    }
    /**
     * Get.
     * @return
     */
    public synchronized int getNum() {
        return num;
    }

    /**
     * Set.
     * @param num
     */
    public synchronized void setNum(int num) {
        this.num = num;
    }

    /**
     * inter.
     */
    public void inter() {
        if (flag) {
            Thread.currentThread().interrupt();
        }
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

                //while (!Thread.currentThread().isInterrupted()) {
                if (file1.getName().indexOf(text) < 0) {

                    if (file1.isDirectory()) {

                        addFiles(file1);

                    }
                } else if (file1.getName().equals("$RECYCLE.BIN")) {


                } else if (file1.getName().indexOf(text) >= 0) {
                    result = file1;
                    flag = true;
                    inter();
                    System.out.printf("%s interrupted", Thread.currentThread().getName());
                }
                //}
            }
        }


        return result;
    }

    /**
     * call.
     * @return
     */
    @Override
    public File call() {

        File x = addFiles(findFiles.get(this.num));

        return x;
    }

    @Override
    public void run() {

        System.out.println("Start thread :" + Thread.currentThread().getName());
        this.temp = addFiles(findFiles.get(this.num));

        System.out.println("Stop thread :" + Thread.currentThread().getName());


    }
}

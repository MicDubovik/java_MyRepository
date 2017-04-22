package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder implements Callable<File> {

    /**
     * List for temp result.
     */
    private List<File> files = new ArrayList<>();
    /**
     * Found file.
     */
    private File file;
    /**
     * Field   text .
     */
    private String text;

    /**
     * Constructor.
     * @param file
     * @param text
     */
    public Finder(File file, String text) {
        this.file = file;
        this.text = text;
    }

    /**
     * Find all files .txt and .doc in directories .
     * Add  files in list.
     *
     * @param file
     */
    public void addFiles(File file) {

        if (file.isDirectory()) {
            for (File nested : file.listFiles()) {
                addFiles(nested);
                if (nested.getName().endsWith(".txt") || nested.getName().endsWith(".doc")) {
                    files.add(nested);
                }
            }
        }
    }

    /**
     * Show   files.
     */
    public void show() {

        for (File file1 : files) {
            System.out.println(file1);
        }

        System.out.println(files.size());
    }

    /**
     * Read file . Find text in files.
     * Return File.
     * @param text
     */
    public File findTextFiles(String text) {


        File res = null;

        for (File file : files) {

            try (FileReader reader = new FileReader(file)) {

                int c;
                List<Character> array = new ArrayList<>();
                while ((c = reader.read()) != -1) {

                    array.add(((char) c));

                }

                StringBuilder result = new StringBuilder();
                for (Character character : array) {
                    result.append(character);
                }

                Pattern pattern = Pattern.compile(text);
                Matcher matcher = pattern.matcher(result);

                if (matcher.find()) {

                    res = file;

                }

            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
        }
        return res;
    }



    @Override
    public File call() {
        addFiles(file);
        File result = findTextFiles(text);

        return result;
    }

    public static void main(String[] args) {
        /**
         * Input args.
         */
        String text = "find";
        File file = new File("D:/TestDir");
        /**
         * Create  callable object.
         */
        Callable<File> callable = new Finder(file, text);
        /**
         * Create FutureTask and give him callable.
         */
        FutureTask<File> futureTask = new FutureTask(callable);
        /**
         * Create ExecutorService.
         */
        ExecutorService service = Executors.newCachedThreadPool();
        /**
         * Start threads.
         */
        service.submit(futureTask);

        boolean flag = false;
        try {
            if (futureTask.get()!=null) {
                service.shutdown();
                flag = true;
            } else {
                service.shutdown();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("========================================");

        try {
            if (flag){
                System.out.println(String.format("Found text in file : %s",futureTask.get()) );
            } else {
                System.out.println(" Text not found");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

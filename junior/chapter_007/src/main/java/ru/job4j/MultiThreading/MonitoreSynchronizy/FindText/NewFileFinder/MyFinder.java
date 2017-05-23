package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.NewFileFinder;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.HashMap;
import java.util.LinkedList;

import java.util.Map;


/**
 * Parser directory.
 */
public class MyFinder implements Runnable {
    /**
     * Temp field for keeping nameDirectory.
     */
    String tempDirectory;
    /**
     * List for keeping files.
     */
    LinkedList<Path> fileList;
    /**
     * Map for keeping files and context.
     */
    Map<Path, String> contentList;
    /**
     * Buffer reference.
     */
    Buffer buffer;

    /**
     * Constructor.
     * @param tempDirectory
     * @param buffer
     */
    public MyFinder(String tempDirectory,  Buffer buffer) {
        this.tempDirectory = tempDirectory;
        this.buffer = buffer;
        this.fileList = new LinkedList<>();
        this.contentList = new HashMap<>();

    }

    /**
     * Find "doc" and "txt" files.
     * @throws IOException
     */
    public void finderFiles() throws IOException {
         String directory = tempDirectory + ":\\";

//          String directory = "d:\\TestDir";
        Path start = FileSystems.getDefault().getPath(directory);
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes attrs) throws IOException {

                if (file.toFile().isFile() && (file.toString().endsWith("doc") || file.toString().endsWith("txt"))) {
                    fileList.add(file);
                }

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exp) {

                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Read content from files.
     * @throws IOException
     */
    public void reader() throws IOException {
        for (Path path : fileList) {

                byte[] cont = Files.readAllBytes(path);

                String content = new String(cont);
                contentList.put(path, content);

        }
    }

    /**
     * run.
     */
    @Override
    public void run() {
        System.out.println("Start finder");
        buffer.paths.putAll(contentList);

    }

}





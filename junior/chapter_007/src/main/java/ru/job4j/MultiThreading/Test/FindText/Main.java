package ru.job4j.MultiThreading.Test.FindText;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Katy on 03.05.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        LinkedList<Path> fileList = new LinkedList<>();

        String tempDirectory = "D:\\TestDir";

        Path start = FileSystems.getDefault().getPath(tempDirectory);
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



        for (Path path : fileList) {
            if (path.toString().contains("ShortLogicComputing")){
                System.out.println(path.toAbsolutePath());
            }


        }
    }

}


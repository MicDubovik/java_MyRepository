package ru.job4j.MultiThreading.Test.FindText;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Katy on 03.05.2017.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    String partOfName = "txt";
    String partOfContent = "Gamer";

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;
        if (partOfName != null && !file.getFileName().toString().endsWith(partOfName))
            containsName = false;

        String content = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if (partOfContent != null && !content.contains(partOfContent))
            containsContent = false;

        if (containsName && containsContent)
            System.out.println(file);

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exp) {

        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {

        Path path = Paths.get("D:\\");

        SimpleFileVisitor  visitor = new MyFileVisitor();
        try {
            Files.walkFileTree(path,visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
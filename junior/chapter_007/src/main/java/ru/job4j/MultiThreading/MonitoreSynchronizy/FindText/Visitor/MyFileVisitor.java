package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.Visitor;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    String partOfName;
    String partOfContent;

    List<Path> foundFiles = new ArrayList<>();

    public MyFileVisitor(String partOfName, String partOfContent) {
        this.partOfName = partOfName;
        this.partOfContent = partOfContent;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            containsName = false;

        String content = new String(Files.readAllBytes(file));
        boolean containsContent = true;
        if (partOfContent != null && !content.contains(partOfContent))
            containsContent = false;

        if (containsName && containsContent){
            foundFiles.add(file);
            return FileVisitResult.TERMINATE;
        } else {
            return FileVisitResult.CONTINUE;
        }



    }

    public static void main(String[] args) {

      MyFileVisitor visitor = new MyFileVisitor("qwe","hi");

      Path start =  Paths.get("D:\\TestDir") ;

        try {
            Files.walkFileTree( start, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Path foundFile : visitor.foundFiles) {
            System.out.printf("%s\n",foundFile);
        }
    }
}

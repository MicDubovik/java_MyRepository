package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.NewFileFinder;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.LinkedList;

import java.util.Scanner;

/**
 * Created by Katy on 02.05.2017.
 */
public class MyFinder {
    public static void main(String[] args) throws IOException {

        LinkedList<Path> fileList = new LinkedList<>();

        System.out.println("Welcome to FileFinder !!! ");
        System.out.println("Enter disk partition for search: ");

        Scanner scanner = new Scanner(System.in);
        String tempDirectory = null;
        if (scanner.hasNext()) {
            tempDirectory = scanner.next();
        }
        String directory = tempDirectory + ":\\";
        System.out.printf("Directory %s \n", directory);
        System.out.println("Enter fileName for search: ");

        String text = null;
        if (scanner.hasNext()) {
            text = scanner.next();
        }

        String finalText = text;
        System.out.printf("File for search %s \n", finalText);

        Path start = FileSystems.getDefault().getPath(directory);
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes attrs) throws IOException {

                if (file.toString().toLowerCase().contains(finalText.toLowerCase())){
                    System.out.println(file);
                    return FileVisitResult.TERMINATE;
                }
                // Можем добавить необходимые файлы в лист и потом из листа забрать для чтения,
                // но опять же одновременно читать несколько файлов мы не можем.
                // Мы лишь можем сократить время удалив ненужные для обработки файлы.
                // Не вижу что здесь можно делать параллельно , если не имею возможности
                // доступа к нескольким файлам.

//                fileList.add(file);

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exp) {

                return FileVisitResult.CONTINUE;
            }
        });


    }
}


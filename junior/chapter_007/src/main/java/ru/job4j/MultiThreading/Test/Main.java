package ru.job4j.MultiThreading.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable{



    List<Integer> fileList = new ArrayList<>();

    List<Integer>  integerList = new ArrayList<>();

    Integer num ;

    public void addToList(Integer[] num){

        for (Integer integer : num) {
            fileList.add(integer);
        }
    }


    @Override
    public void run() {
        Integer in = fileList.remove(0);
        System.out.println(Thread.currentThread().getName()+"add "+in);
        integerList.add(in);
    }

    public static void main(String[] args) throws InterruptedException {

        File file = new File("d:/");

        Integer[] num =new Integer[] {1,2,3,3,45,6};

        Main main = new Main();

        main.addToList(num);

        for (int i = 0; i < main.fileList.size(); i++) {

            new Thread(main).start();
        }

        Thread.sleep(500);

        System.out.println("filelist :"+main.fileList);
        System.out.println("integerList :"+main.integerList);
    }


}
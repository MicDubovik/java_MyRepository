package ru.job4j.MultiThreading.Bomberman;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {

        int amountMonster = 5;

        Field  field = new Field(64,64);

        Runnable bomber = new Bomberman("Vasya");

        Thread one = new Thread(bomber);

        List<Monster>  monsterList = new ArrayList<>();

        for (int i = 0; i <amountMonster  ; i++) {
            monsterList.add(new Monster(field));
        }

         List<Thread> threadList = new ArrayList<>();

        for (Monster monster : monsterList) {
            threadList.add(new Thread(monster));
        }

        one.start();
        for (Thread thread : threadList) {
            thread.start();
        }
    }
}

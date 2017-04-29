package ru.job4j.MultiThreading.Bomberman;

import java.util.Random;

public class Stone {



    private int posStH;

    private int posStV;

    public Stone() {

        posStone();
    }

    public void posStone(){
        Random random = new Random();

        this.posStH = random.nextInt(65);
        this.posStV = random.nextInt(65);
    }
}

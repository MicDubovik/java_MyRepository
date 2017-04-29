package ru.job4j.MultiThreading.Bomberman;

import java.util.Random;

/**
 * Stone.
 */
public class Stone {
    /**
     * Position horizontal.
     */
    private int posStH;
    /**
     * Position vertical.
     */
    private int posStV;

    /**
     * Constructor.
     */
    public Stone() {

        posStone();
    }

    /**
     * Random position for new stone.
     */
    public void posStone(){
        Random random = new Random();

        this.posStH = random.nextInt(65);
        this.posStV = random.nextInt(65);
    }

    public int getPosStH() {
        return posStH;
    }

    public int getPosStV() {
        return posStV;
    }
}

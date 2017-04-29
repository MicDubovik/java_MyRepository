package ru.job4j.MultiThreading.Bomberman;

import java.util.Random;

public class Monster implements IMonster{

    private String name;

    private int posH;

    private int posV;


    public Monster(String name ) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosH() {
        return posH;
    }

    public void setPosH(int positionH) {
        this.posH = positionH;
    }

    public int getPosV() {
        return posV;
    }

    public void setPosV(int positionV) {
        this.posV = positionV;
    }

    public void move(){
        Random random = new Random();


    }

    public static void main(String[] args) {

        Random random = new Random( );

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s num\n",random.nextInt(5));
        }

    }
}

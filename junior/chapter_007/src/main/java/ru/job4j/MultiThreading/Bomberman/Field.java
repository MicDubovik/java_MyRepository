package ru.job4j.MultiThreading.Bomberman;

import java.util.ArrayList;
import java.util.List;

public class Field implements IField{

    private int size1;

    private int size2;



 private List<Stone> stoneList ;

    public Field(int size1, int size2) {
        this.size1 = size1;
        this.size2 = size2;
        this.stoneList = new ArrayList<>();
    }

    public int getSize1() {
        return size1;
    }

    public void setSize1(int size1) {
        this.size1 = size1;
    }

    public int getSize2() {
        return size2;
    }

    public void setSize2(int size2) {
        this.size2 = size2;
    }

    public  void addStone(int amount){
        for (int i = 0; i < amount; i++) {
            stoneList.add(new Stone());
        }
    }
}

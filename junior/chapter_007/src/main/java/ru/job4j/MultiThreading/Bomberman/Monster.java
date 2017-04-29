package ru.job4j.MultiThreading.Bomberman;

import java.util.Random;

public class Monster implements IMonster,Runnable {

    private Field field;

    private String name;

    private Celling pos;


    Random random = new Random();


    public Monster( Field field) {
        this.name = name;
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void primaryPos() {
        int posRandom = random.nextInt(field.getCellList().size());
        boolean posBool = this.field.getCellList().get(posRandom).isOccupied();

        do {
            this.pos = field.getCellList().get(posRandom);

        } while (posBool);

    }

    public void move(Boolean flag) {


        while (flag) {
            int course = random.nextInt(5);
            switch (course) {
                case 0:
                    do {
                        if (pos.getRight()!=null){
                            this.pos = pos.getRight();
                        } else return;


                    } while (!pos.isOccupied()  );
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    do {
                        if (pos.getLeft()==null){
                            this.pos = pos.getLeft();
                        } else return;

                    } while (!pos.isOccupied());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    do {
                        if (pos.getUp()==null){
                            this.pos = pos.getUp();
                        } else return;

                    }while (!pos.isOccupied());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    do {
                        if (pos.getDown()==null){
                            this.pos = pos.getDown();
                        } else return;

                    }while (!pos.isOccupied());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    @Override
    public void   run()   {
        boolean flag = false;
        move(flag);

    }
}

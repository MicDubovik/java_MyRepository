package ru.job4j.MultiThreading.Bomberman;

import java.util.Random;

public class Monster implements IMonster,Runnable {
    /**
     * Reference to  the field.
     */
    private Field field;
    /**
     * Position monster.
     */
    private Celling pos;
    /**
     * Volatile flag=true if here stay monster.
     */
    private volatile boolean occupiedM = false;

    /**
     * For random calculating.
     */
    Random random = new Random();

    /**
     * Constructor.
     * @param field
     */
    public Monster( Field field) {

        this.field = field;
    }

    /**
     * Random start position monster.
     */
    public void startPos() {
        int posRandom = random.nextInt(field.getCellList().size());
        boolean posBool = this.field.getCellList().get(posRandom).isOccupied();

        do {
            this.pos = field.getCellList().get(posRandom);
            this.pos.setOccupied(true);

        } while (posBool);

    }

    /**
     * Method for move monster.
     * @param flag
     */
    public  void move(Boolean flag) {


        while (flag) {
            int course = random.nextInt(5);
            switch (course) {
                case 0:
                    do {
                        if (pos.getRight()!=null ){
                            this.pos = pos.getRight();
                            this.pos.setOccupied(true);
                            this.pos.getLeft().setOccupied(false);
                        } else return;


                    } while (!pos.getRight().isOccupied());
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
                            this.pos.setOccupied(true);
                            this.pos.getRight().setOccupied(false);
                        } else return;

                    } while (!pos.getLeft().isOccupied());
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
                            this.pos.setOccupied(true);
                            this.pos.getDown().setOccupied(false);
                        } else return;

                    }while (!pos.getUp().isOccupied());
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
                            this.pos.setOccupied(true);
                            this.pos.getUp().setOccupied(false);
                        } else return;

                    }while (!pos.getDown().isOccupied());
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

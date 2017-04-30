package ru.job4j.MultiThreading.Bomberman;

import java.util.Random;

public class Monster implements Runnable {
    /**
     * Reference to  the field.
     */
    private Field field;
    /**
     * Position monster.
     */
    private Cell pos;
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
     *
     * @param field
     */
    public Monster(Field field) {

        this.field = field;
        startPos();
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
     *
     * @param flag
     */
    public void move(Boolean flag) {

        boolean occup = false;

        while (flag) {
            int course = random.nextInt(5);
            switch (course) {
                case 0:
                    do {
                        Cell temp = new Cell(pos.getH() + 1, pos.getV());

                        for (Cell cell : field.getCellList()) {
                            if (cell.equals(temp)) {
                                if (cell.isOccupied()) {
                                    occup = true;
                                }
                            }
                        }
                        if (pos.getH() + 1 <= pos.getMAXSIZE() && !occup) {

                            this.pos.setOccupied(false);
                            this.pos.setH(pos.getH() + 1);
                            this.pos.setOccupied(true);

                        } else return;


                    } while (!occup);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    do {
                        Cell temp = new Cell(pos.getH() - 1, pos.getV());

                        for (Cell cell : field.getCellList()) {
                            if (cell.equals(temp)) {
                                if (cell.isOccupied()) {
                                    occup = true;
                                }
                            }
                        }
                        if (pos.getH() - 1 >= pos.getMINSIZE() && !occup) {

                            this.pos.setOccupied(false);
                            this.pos.setH(pos.getH() -1);
                            this.pos.setOccupied(true);

                        } else return;

                    }
                    while (!occup);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    do {
                        Cell temp = new Cell(pos.getH(), pos.getV()+1);

                        for (Cell cell : field.getCellList()) {
                            if (cell.equals(temp)) {
                                if (cell.isOccupied()) {
                                    occup = true;
                                }
                            }
                        }
                        if (pos.getV() + 1 <= pos.getMAXSIZE() && !occup) {

                            this.pos.setOccupied(false);
                            this.pos.setV(pos.getV() + 1);
                            this.pos.setOccupied(true);

                        } else return;


                    } while (!occup);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    do {
                        Cell temp = new Cell(pos.getH(), pos.getV()-1);

                        for (Cell cell : field.getCellList()) {
                            if (cell.equals(temp)) {
                                if (cell.isOccupied()) {
                                    occup = true;
                                }
                            }
                        }
                        if (pos.getV() - 1 >= pos.getMINSIZE() && !occup) {

                            this.pos.setOccupied(false);
                            this.pos.setV(pos.getV() -1);
                            this.pos.setOccupied(true);

                        } else return;

                    }
                    while (!occup);
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
    public void run() {
        boolean flag = false;
        move(flag);

    }
}

package ru.job4j.MultiThreading.Bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Field {
    /**
     * Size field horizontal.
     */
    private int size1;
    /**
     * Size field vertical.
     */
    private int size2;
    /**
     * List stones on the field.
     */
    private List<Stone> stoneList;
    /**
     * Field consist from list cells.
     */
    private CopyOnWriteArrayList<Celling> cellList;

    /**
     * Constructor.
     * @param size1
     * @param size2
     */
    public Field(int size1, int size2) {
        this.size1 = size1;
        this.size2 = size2;
        this.stoneList = new ArrayList<>();
        this.cellList = new CopyOnWriteArrayList<Celling>();
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

    public List<Stone> getStoneList() {
        return stoneList;
    }

    public void setStoneList(List<Stone> stoneList) {
        this.stoneList = stoneList;
    }

    public synchronized CopyOnWriteArrayList<Celling> getCellList() {
        return cellList;
    }

    public synchronized void setCellList(CopyOnWriteArrayList<Celling> cellList) {
        this.cellList = cellList;
    }

    /**
     * Add stone into the list.
     * @param amount
     */
    public void addStone(int amount) {
        for (int i = 0; i < amount; i++) {
            stoneList.add(new Stone());
        }
    }

    /**
     *  Flag if cell occupied stone.
     * @param stones
     */
    public  void occupied(List<Stone> stones) {
        for (Celling cell : cellList) {
            for (Stone stone : stones) {
                if (cell.getX() == stone.getPosStH() && cell.getY() == stone.getPosStV()) {
                    cell.setOccupied(true);
                }
            }
        }
    }

}
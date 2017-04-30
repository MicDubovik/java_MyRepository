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
    private CopyOnWriteArrayList<Cell> cellList;

    /**
     * Constructor.
     * @param size1
     * @param size2
     */
    public Field(int size1, int size2) {
        this.size1 = size1;
        this.size2 = size2;
        this.stoneList = new ArrayList<>();
        this.cellList = new CopyOnWriteArrayList<Cell>();
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

    public synchronized CopyOnWriteArrayList<Cell> getCellList() {
        return cellList;
    }

    public synchronized void setCellList(CopyOnWriteArrayList<Cell> cellList) {
        this.cellList = cellList;
    }

    /**
     * For to fill listCell .
     */
    public void fillCell(){
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                cellList.add(new Cell(i,j));
            }
        }
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
     *
     */
    public  void occupied() {
        for (Cell cell : cellList) {
            for (Stone stone : this.stoneList) {
                if (cell.getH() == stone.getPosStH() && cell.getV() == stone.getPosStV()) {
                    cell.setOccupied(true);
                }
            }
        }
    }

}
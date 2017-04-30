package ru.job4j.MultiThreading.Test;

/**
 * Create cell as LinkedList Node.
 */
public class Celling {

    private final int maxSize = 10;
    private final int minSize = 0;
    /**
     * Value x,y.
     */
    private int x;
    private int y;
    /**
     * Flag for occupied cell.
     */
    private boolean occupied = false;

    /**
     * Reference on the cell.
     */


    public Celling() {

    }
//
//    public Celling left() {
//        if (this.x - 1 >= minSize) {
//            this.left.setX(this.x - 1);
//            this.left.setY(this.y);
//        } else this.left = null;
//        return left;
//    }
//
//    public Celling right() {
//        if (this.x + 1 <= maxSize) {
//            this.right.setX(this.x + 1);
//            this.right.setY(this.y);
//        } else this.right = null;
//        return right;
//    }
//
//    public Celling up() {
//        if (this.y <= maxSize) {
//            this.up.setX(this.x);
//            this.up.setY(this.y + 1);
//        } else this.up = null;
//        return up;
//    }
//
//    public Celling down() {
//        if (this.y - 1 >= 0) {
//            this.down.setX(this.x);
//            this.down.setY(this.y-1);
//        } else down = null;
//        return down;
//    }
//
//    public int getMaxSize() {
//        return maxSize;
//    }
//
//    public int getMinSize() {
//        return minSize;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public boolean isOccupied() {
//        return occupied;
//    }
//
//    public void setOccupied(boolean occupied) {
//        this.occupied = occupied;
//    }
//
//    public Celling getLeft() {
//
//        return left;
//
//    }
//
//    public void setLeft(Celling left) {
//        this.left = left;
//    }
//
//    public Celling getRight() {
//        return right;
//    }
//
//    public void setRight(Celling right) {
//        this.right = right;
//    }
//
//    public Celling getUp() {
//        return up;
//    }
//
//    public void setUp(Celling up) {
//        this.up = up;
//    }
//
//    public Celling getDown() {
//        return down;
//    }
//
//    public void setDown(Celling down) {
//        this.down = down;
//    }
//
//    public static void main(String[] args) {
//
//        Celling celling = new Celling();
//        celling.setX(5);
//        celling.setY(5);
//        celling.left();


//        System.out.printf("Primary %s ,%s \n", celling.getX(), celling.getY());
//        System.out.printf("Left %s ,%s \n", celling.getLeft().getX(), celling.getLeft().getY());
//        System.out.printf("Right %s ,%s \n", celling.getRight().getX(), celling.getRight().getY());
//        System.out.printf("Up %s ,%s \n",celling.getUp().getX(),celling.getUp().getY());
//        System.out.printf("Down %s ,%s \n",celling.getDown().getX(),celling.getDown().getY());
}

package ru.job4j.MultiThreading.Bomberman;



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
    private Celling left;
    private Celling right;
    private Celling up;
    private Celling down;

    public Celling(int x, int y) {
        this.x = x;
        this.y = y;
        this.left = left();
        this.right = right();
        this.up = up();
        this.down = down();

    }

    public Celling left() {
        if (this.x - 1 >= minSize) {
            this.left = new Celling(this.x - 1, this.y);
        } else this.left = null;
        return left;
    }

    public Celling right() {
        if (this.x + 1 <= maxSize) {
            this.right = new Celling(this.x + 1, this.y);
        } else this.right = null;
        return right;
    }

    public Celling up() {
        if (this.y <= maxSize) {
            this.up = new Celling(this.x, this.y + 1);
        } else this.up = null;
        return up;
    }

    public Celling down() {
        if (this.y - 1 >= 0) {
            this.down = new Celling(this.x, this.y - 1);
        } else down = null;
        return down;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Celling getLeft() {
        return left;
    }

    public void setLeft(Celling left) {
        this.left = left;
    }

    public Celling getRight() {
        return right;
    }

    public void setRight(Celling right) {
        this.right = right;
    }

    public Celling getUp() {
        return up;
    }

    public void setUp(Celling up) {
        this.up = up;
    }

    public Celling getDown() {
        return down;
    }

    public void setDown(Celling down) {
        this.down = down;
    }
}
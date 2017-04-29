package ru.job4j.MultiThreading.Bomberman;

/**
 * Bomberman.
 */
public class Bomberman implements Runnable {
    /**
     * Name.
     */
    private String name;
    /**
     * Flag for stop move.
     */
    private Boolean flag = false;
    /**
     * Flag for exit from game.
     */
    private boolean stopMove = true;
    /**
     * Reference on Cell.
      */
    private Celling myPos;
    /**
     * Operation for select course move.
     */
    private int operation;

    /**
     * Constructor.
     * @param name
     */
    public Bomberman(String name) {
        this.name = name;
    }

    /**
     * Move  right.
     * @param flag
     */
    public void moveRight(Boolean flag) {
        synchronized (this) {
            if (myPos.getRight() != null && !myPos.getRight().isOccupied()) {
                this.myPos = myPos.getRight();
            }
        }
    }
    /**
     * Move  left.
     * @param flag
     */
    public void moveLeft(Boolean flag) {
        synchronized (this) {
            if (myPos.getLeft() != null && !myPos.getLeft().isOccupied()) {
                this.myPos = myPos.getLeft();
            }
        }
    }
    /**
     * Move up.
     * @param flag
     */
    public void moveUp(Boolean flag) {
        synchronized (this) {
            if (myPos.getUp() != null && !myPos.getUp().isOccupied()) {
                this.myPos = myPos.getUp();
            }
        }
    }
    /**
     * Move down.
     * @param flag
     */
    public void moveDown(Boolean flag) {
        synchronized (this) {
            if (myPos.getDown() != null && !myPos.getDown().isOccupied()) {
                this.myPos = myPos.getDown();
            }

        }
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public void run() {
        while (this.stopMove) {
            if (this.operation == 0) {
                moveRight(this.flag);
            } else if (this.operation == 1) {
                moveLeft(this.flag);
            } else if (this.operation == 2) {
                moveUp(this.flag);
            } else {
                moveDown(flag);
            }
        }
    }
}

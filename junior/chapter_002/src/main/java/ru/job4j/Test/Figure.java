package ru.job4j.Test;

/**
 * Figure.
 */
public abstract class Figure {
    /**
     * Name.
     */
    String name;
    /**
     * Position.
     */
    Cell position;

    /**
     * Constructor.
     */
    public Figure() {
    }

    /**
     * Constructor.
     *
     * @param name
     * @param position
     */
    public Figure(String name, Cell position) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract method move.
     * @param newposition
     * @return
     */
    public abstract Cell move(Cell newposition);

}



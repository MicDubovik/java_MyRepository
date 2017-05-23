package ru.job4j.Test;

/**
 * Rook.
 */
public class Rook extends Figure{
    /**
     * Constructor.
     */
    public Rook() {
        super("Rook", new Cell(1,1));
        new Rook();
    }

    /**
     * Move.
     * @param newposition
     * @return Cell.
     */
    @Override
    public Cell move(Cell newposition) {
        return null;
    }


}

package ru.job4j.Test;

/**
 * Board.
 */
public class Board {
    Cell[] cell = new Cell[64];
    Figure[] figure;

    /**
     * Constructor.
     * @param cell
     */
    public Board(Cell[] cell) {
        this.cell = cell;
    }

    /**
     * Constructor.
     */
    public Board() {
    }

    /**
     * fillBoard.
     */
    public void fillBoard() {

        Figure figure = new Bishop();
        Figure figure1 = new Rook();

        cell[0].setStatus(figure.name);
        cell[1].setStatus(figure1.name);

    }


}

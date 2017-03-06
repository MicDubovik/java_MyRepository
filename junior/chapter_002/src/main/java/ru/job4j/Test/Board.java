package ru.job4j.Test;

/**
 * Created by Katy on 05.03.2017.
 */
public class Board {
    Cell[] cell = new Cell[64];
    Figure[] figure;


    public Board(Cell[] cell) {
        this.cell = cell;
    }

    public Board() {
    }

    public void fillBoard() {

        Figure figure = new Bishop();
        Figure figure1 = new Rook();

        cell[0].setStatus(figure.name);
        cell[1].setStatus(figure1.name);

    }


}

package ru.job4j.Chess;

/**
 * Created by Katy on 06.03.2017.
 */
public class Game {
    Figure[] figures;
    Board boards;

    public Game(Figure[] figures, Board boards) {
        this.figures = figures;
        this.boards = boards;
    }

    public void start() throws ImpossibleMoveException {
        System.out.println("Select figure");
        System.out.println("Enter new position ");

        boards.fillBoard();

        Figure figure = new Bishop();
        Figure figure1 = new Rook();

        figure.way(new Cell(5,3));
        figure1.way(new Cell(1,3));

    }


}
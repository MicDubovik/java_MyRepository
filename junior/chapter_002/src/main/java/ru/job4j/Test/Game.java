package ru.job4j.Test;

/**
 * Created by Katy on 05.03.2017.
 */
public class Game {
    Figure[] figures;
    Board boards;

    public Game(Figure[] figures, Board boards) {
        this.figures = figures;
        this.boards = boards;
    }

    public void start() {
        System.out.println("Select figure");
        System.out.println("Enter new position ");

        Figure figure = new Bishop();
        Figure figure1 = new Rook();

        figure.move(new Cell(5,3));
        figure1.move(new Cell(1,3));

    }


}

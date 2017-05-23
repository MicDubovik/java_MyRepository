package ru.job4j.Test;

/**
 * Game.
 */
public class Game {
    /**
     * Reference to the array figures.
     */
    Figure[] figures;
    /**
     * Reference to the boards.
     */
    Board boards;

    /**
     * Constructor.
     * @param figures
     * @param boards
     */
    public Game(Figure[] figures, Board boards) {
        this.figures = figures;
        this.boards = boards;
    }

    /**
     * Start.
     */
    public void start() {
        System.out.println("Select figure");
        System.out.println("Enter new position ");

        Figure figure = new Bishop();
        Figure figure1 = new Rook();

        figure.move(new Cell(5,3));
        figure1.move(new Cell(1,3));

    }


}

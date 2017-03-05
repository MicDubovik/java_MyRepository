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
        boards.cell[0] = new Cell(1, 1);
//        boards.position = 0;
        figures[0].name = "slon";
        figures[0].startposition = new Cell(1, 2);

    }

    public static void main(String[] args) {




    }
}

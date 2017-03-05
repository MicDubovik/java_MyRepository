package ru.job4j.Chess;

/**
 * Created by Katy on 05.03.2017.
 */
public class Board {
    Figure[] figures;
    Cell cell;

    public Board(Figure[] figures, Cell cell) {
        this.figures = figures;
        this.cell = cell;
    }

//   public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
//
//    }
//
//    public void hod(Figure figure,Cell cell){
//        figure
//
//    }

    public static void main(String[] args) {

        Cell cell = new Cell(1,1);


    }
}

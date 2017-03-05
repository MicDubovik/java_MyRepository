package ru.job4j.Chess;

/**
 * Created by Katy on 05.03.2017.
 */
public abstract class Figure {

    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }
//   public Cell[] way(Cell dist) throws ImpossibleMoveException {
//
//
//    }

    public abstract Figure clone(Cell dist);


}

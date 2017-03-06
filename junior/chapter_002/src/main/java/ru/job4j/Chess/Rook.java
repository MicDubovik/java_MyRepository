package ru.job4j.Chess;

/**
 * Created by Katy on 06.03.2017.
 */
public class Rook extends Figure{



    public Rook() {
        super("Rook", new Cell());
        new Rook();
    }

    @Override
    public Cell move(Cell newposition) {
        return null;
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        return new Cell[0];
    }


}

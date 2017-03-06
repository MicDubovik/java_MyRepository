package ru.job4j.Test;

/**
 * Created by Katy on 06.03.2017.
 */
public class Rook extends Figure{



    public Rook() {
        super("Rook", new Cell(1,1));
        new Rook();
    }

    @Override
    public Cell move(Cell newposition) {
        return null;
    }


}

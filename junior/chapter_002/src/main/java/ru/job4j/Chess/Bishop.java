package ru.job4j.Chess;


/**
 * Создаем фигуру - Слон .
 */
public class Bishop extends Figure {

    public Bishop() {
        super("Bishop", new Cell());
        new Bishop();
    }


    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        /**
         * алгоритм получения массива ячеек
         *    вариантов перемещения фигуры
         */
        Cell[] cells = new Cell[64] ;
        return    cells ;
    }
}
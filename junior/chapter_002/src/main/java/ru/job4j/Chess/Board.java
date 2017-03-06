package ru.job4j.Chess;

/**
 * Создаем шахматную доску.
 */


public class Board {
    /**
     * Доска состоит из массива ячеек и на ней расположены фигуры.
     */
    Cell[] cell = new Cell[64];
    Figure[] figure;


    public Board(Cell[] cell) {
        this.cell = cell;
    }

    public Board() {
    }

    /**
     * Заполняем фигурами доску,
     * При заполнении доски фигурами ячейке на которой
     * находится фигура присваиваем статус занято(к примеру используем имя фигуры).
     */

    public void fillBoard() {

        Figure figure = new Bishop();
        Figure figure1 = new Rook();

        cell[0].setStatus(figure.name);
        cell[1].setStatus(figure1.name);

    }

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        /**
         * Алгоритм проверки ячеек на присутствие в ней фигуры;
         * Проверка что полученный путь. не занят фигурами;
         * Записать в ячейку новое новое положение
         */
        if (true) {

        } else {
            throw new FigureNotFoundException ("Exception ... Figure not found!") ;
        }
        if(true) {

        } else {
            throw new ImpossibleMoveException ("Exception ...Impossible cell for move!");
        }
        if(true) {

        } else {
            throw new OccupiedWayException ("Exception ... Occupied way for moving");
        }
        return true;
    }
}
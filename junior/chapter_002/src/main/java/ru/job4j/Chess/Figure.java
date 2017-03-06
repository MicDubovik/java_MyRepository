package ru.job4j.Chess;

/**
 * Абстрактный класс описывающий общие
 * свойства фигур.
 */
public abstract class Figure {

    String name;
    Cell position;




    public Figure() {
    }

    public Figure(String name ,Cell position ) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;



}
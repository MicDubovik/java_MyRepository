package ru.job4j.Test;

/**
 * Created by Katy on 05.03.2017.
 */
public class Figure {

    String name;

    Cell startposition;
    Cell newposition;

    public Figure(String name, Cell startposition, Cell newposition) {
        this.name = name;
        this.startposition = startposition;
        this.newposition = newposition;
    }

    public Cell move(Cell startposition , Cell newposition) {

//        if (newposition.getX()!= )
        newposition.setX(startposition.getX()+7);
        newposition.setY(startposition.getY()+7);
        return newposition ;
    }

}

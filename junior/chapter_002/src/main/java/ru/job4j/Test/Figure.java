package ru.job4j.Test;

/**
 * Created by Katy on 05.03.2017.
 */
public abstract class Figure {

    String name;
    Cell position;

   // Cell  position;


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

    public abstract Cell move(Cell newposition );



    }



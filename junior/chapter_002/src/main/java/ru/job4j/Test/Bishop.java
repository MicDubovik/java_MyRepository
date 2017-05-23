package ru.job4j.Test;

/**
 * Created by Katy on 06.03.2017.
 */
public class Bishop extends Figure {

    public Bishop() {
        super("Bishop",  new Cell(3,1));
         new Bishop();
    }


    /**
     * Move.
     * @param newposition
     * @return
     */
    @Override
    public Cell move( Cell newposition) {

        if (!newposition.getStatus().equals("empty")) {

            for (int i = 0; i <newposition.getX()-this.position.getX() ; i++) {
                if (!this.position.getStatus().equals("empty"))
                this.position.setX(this.position.getX()+1);
                this.position.setY(this.position.getY()+1);;
            }
        }
        return position;
    }
}

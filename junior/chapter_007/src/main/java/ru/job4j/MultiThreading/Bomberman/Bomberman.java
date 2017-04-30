package ru.job4j.MultiThreading.Bomberman;

/**
 * Bomberman.
 */
public class Bomberman extends Cell implements Runnable  {
    /**
     * Name.
     */
    private String name;
    /**
     * Flag for stop move.
     */
    private Boolean flag = false;
    /**
     * Flag for exit from game.
     */
    private boolean stopMove = true;
    /**
     * Reference on Cell.
      */


    private Field field;
    /**
     * Operation for select course move.
     */
    private int operation;

    /**
     * Constructor.
     * @param name
     */
    public Bomberman(String name,int x , int y) {
        super(x,y);

        this.name = name;

    }


    public void moveRight() {

            boolean toRight=false;
            Cell temp =new Cell(this.getH()+1,this.getV());

            for (Cell cell : field.getCellList()) {
                if (cell.equals(temp)){
                    if (cell.isOccupied()){
                        toRight = true;
                    }
                }
            }
            if (this.getH()  <this.getMAXSIZE()  && !toRight ) {
                this.setH(getH()+1);
            }

    }
    /**
     * Move  left.
     *
     */
    public void moveLeft( ) {
        boolean toLeft=false;
        Cell temp =new Cell(this.getH()-1,this.getV());

        for (Cell cell : field.getCellList()) {
            if (cell.equals(temp)){
                if (cell.isOccupied()){
                    toLeft = true;
                }
            }
        }
        if (this.getH()  >this.getMINSIZE()  && !toLeft ) {
            this.setH(getH()-1);
        }
    }
    /**
     * Move up.
     *
     */
    public void moveUp() {
        boolean toUp=false;
        Cell temp =new Cell(this.getH(),this.getV()+1);

        for (Cell cell : field.getCellList()) {
            if (cell.equals(temp)){
                if (cell.isOccupied()){
                    toUp = true;
                }
            }
        }
        if (this.getV()  <this.getMAXSIZE()  && !toUp ) {
            this.setV(getV()+1);
        }
    }
    /**
     * Move down.
     * @param flag
     */
    public void moveDown(Boolean flag) {
        boolean toDown=false;
        Cell temp =new Cell(this.getH(),this.getV()-1);

        for (Cell cell : field.getCellList()) {
            if (cell.equals(temp)){
                if (cell.isOccupied()){
                    toDown = true;
                }
            }
        }
        if (this.getV()  > this.getMINSIZE()  && !toDown ) {
            this.setV(getV()-1);
        }
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public void run() {
        while (this.stopMove) {
            if (this.operation == 0) {
                moveRight();
            } else if (this.operation == 1) {
                moveLeft();
            } else if (this.operation == 2) {
                moveUp();
            } else {
                moveDown(flag);
            }
        }
    }
}

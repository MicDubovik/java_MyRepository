package ru.job4j.newFood;

/**
 * NewFood
 */
public class NewFood extends Food {
    /**
     * boolean canReproduct.
     */
    protected boolean canReproduct ;

    /**
     * Constructor.
     * @param canReproduct
     */
    public NewFood(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    /**
     * Constructor.
     * @param name
     * @param expiryDate
     * @param createDate
     * @param price
     * @param disscount
     * @param canReproduct
     */
    public NewFood(String name, String expiryDate, String createDate, int price, int disscount, boolean canReproduct) {
        super(name, expiryDate, createDate, price, disscount);
        this.canReproduct = canReproduct;
    }

}

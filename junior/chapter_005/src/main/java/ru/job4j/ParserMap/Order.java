package ru.job4j.ParserMap;

/**
 * Class order of Book.
 */
public class Order {
    /**
     * Action sell or buy.
     */
    private String action;
    /**
     * id of order.
     */
    private int id;
    /**
     * price of order.
     */
    private double price;
    /**
     * count of volume.
     */
    private int volume;

    /**
     * Constructor.
     * @param action action
     * @param price price
     * @param volume volume
     * @param id id
     */
    public Order(String action, double price, int volume, int id) {
        this.action = action;
        this.volume = volume;
        this.price = price;
        this.id = id;
    }


    /**
     * Constructor by id.
     * @param id id
     */
    public Order(int id) {
        this.id = id;
    }

    /**
     * Getter.
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter.
     * @return volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Getter.
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * Getter.
     * @return id.
     */
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id;
    }
    @Override
    public int hashCode() {
        return id;
    }


}

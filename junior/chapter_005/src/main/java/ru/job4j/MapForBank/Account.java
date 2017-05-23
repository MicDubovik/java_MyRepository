package ru.job4j.MapForBank;

/**
 * Class Account.
 *
 */
public class Account {
    /**
     * Value.
     */
    private int value;
    /**
     * requisites.
     */
    private int requisites;

    /**
     * Constructor.
     * @param value
     * @param requisites
     */
    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Constructor.
     * @param requisites
     */
    public Account(int requisites) {
        this.requisites = requisites;
    }

    /**
     * Get.
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Set.
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * Get.
     * @return
     */
    public int getRequisites() {
        return requisites;
    }

    /**
     * Set.
     * @param requisites
     */
    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }


}

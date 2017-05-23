package ru.job4j.newFood;

/**
 *
 */
public class Food {
    /**
     * name.
     */
    protected   String name;
    /**
     * expiryDate.
     */
    protected String expiryDate  ;
    /**
     * createDate
     */
    protected String createDate; // "dd.MM.yyyy"
    /**
     * price.
     */
    protected int price;
    /**
     * disscount.
     */
    protected int disscount;

    /**
     * Constructor.
     */
    public Food() {
    }

    /**
     * Constructor.
     * @param name
     * @param expiryDate
     * @param createDate
     * @param price
     * @param disscount
     */
    public Food(String name, String expiryDate, String createDate, int price, int disscount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;

        this.price = price;
        this.disscount = disscount;
    }

    /**
     * Get.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get.
     * @return
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Set.
     * @param expiryDate
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    /**
     * Get.
     * @return
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Set.
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    /**
     * Get.
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set.
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Get.
     * @return
     */
    public int getDisscount() {
        return disscount;
    }

    /**
     * Set.
     * @param disscount
     */
    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }
}

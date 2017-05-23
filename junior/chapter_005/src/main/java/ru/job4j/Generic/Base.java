package ru.job4j.Generic;

/**
 * Base.
 */
public abstract class Base {
    /**
     * Id.
     */
    private String id ;

    /**
     * Constructor.
     * @param id
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * Get.
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Set.
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}

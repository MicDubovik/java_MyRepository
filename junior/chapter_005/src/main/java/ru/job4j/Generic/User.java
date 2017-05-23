package ru.job4j.Generic;

/**
 * User.
 */
public class User extends Base{
    /**
     * Constructor.
     * @param id
     */
    public User(String id) {
        super(id);
    }

    /**
     * Get.
     * @return
     */
    @Override
    public String getId() {
        return super.getId();
    }

    /**
     * Set.
     * @param id
     */
    @Override
    public void setId(String id) {
        super.setId(id);
    }
}

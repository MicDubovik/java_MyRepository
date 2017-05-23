package ru.job4j.Generic;

/**
 * Role.
 */
public class Role extends Base {
    /**
     * Constructor.
     * @param id
     */
    public Role(String id) {
        super( id);
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

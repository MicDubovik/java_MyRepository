package ru.job4j.Generic;

/**
 * RoleStore
 */
public class RoleStore implements Store<Role> {
    /**
     * Size.
     */
    int size = 5;
    /**
     * List roleSimple.
     */
    SimpleArray<Role> roleSimple = new SimpleArray<>(size);

    /**
     * Add.
     * @param obj
     */
    @Override
    public void add(Role obj) {
        this.roleSimple.add(obj);
    }

    /**
     * update.
     * @param obj
     * @param id
     */
    @Override
    public void update(Role obj, String id) {

        this.roleSimple.update(obj, getIndexById(id));
    }

    /**
     * Delete.
     * @param id
     */
    @Override
    public void delete(String id) {
        this.roleSimple.delete(getIndexById(id));
    }

    /**
     * Get.
     * @param id
     * @return
     */
    @Override
    public Role get(String id) {
        return this.roleSimple.get(getIndexById(id));
    }

    /**
     * getIndexById.
     * @param id
     * @return
     */
    private Integer getIndexById(String id) {
        Integer result = -1;
        for (int index = 0; index < this.size; index++) {
            if (this.roleSimple.get(index) != null && id.equals(this.roleSimple.get(index).getId())) {
                result = index;
                break;
            }
        }
        return result;
    }
}

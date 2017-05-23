package ru.job4j.Generic;

/**
 * UserStore.
 */
public class UserStore implements Store<User> {
    /**
     * Size.
     */
    int size =5;
    /**
     * List User.
     */
    SimpleArray<User> simpleArray = new SimpleArray<>(size);

    /**
     * Add.
     * @param obj
     */
    @Override
    public void add(User obj) {
        this.simpleArray.add(obj);
    }

    /**
     * Update.
     * @param obj
     * @param id
     */
    @Override
    public void update(User obj, String id) {
        this.simpleArray.update(obj,getIndexById(id) );
    }

    /**
     * Delete.
     * @param id
     */
    @Override
    public void delete(String id){
        this.simpleArray.delete(getIndexById(id));
    }

    /**
     * Get.
     * @param id
     * @return
     */
    @Override
    public  User get(String id){
        return this.simpleArray.get(getIndexById(id));
    }

    /**
     * getIndexById.
     * @param id
     * @return
     */
    private Integer getIndexById(String id) {
        Integer result = -1;
        for (int index = 0; index < this.size; index++) {
            if (this.simpleArray.get(index) != null && id.equals(this.simpleArray.get(index).getId())) {
                result = index;
                break;
            }
        }
        return result;
    }

}

package ru.job4j.Generic;

public class UserStore implements Store<User> {

    int size =5;

    SimpleArray<User> simpleArray = new SimpleArray<>(size);



    @Override
    public void add(User obj) {
        this.simpleArray.add(obj);
    }

    @Override
    public void update(User obj, String id) {
        this.simpleArray.update(obj,getIndexById(id) );
    }
    @Override
    public void delete(String id){
        this.simpleArray.delete(getIndexById(id));
    }

    @Override
    public  User get(String id){
        return this.simpleArray.get(getIndexById(id));
    }

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

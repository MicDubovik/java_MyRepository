package ru.job4j.Generic;

public class UserStore implements Store<User> {

    SimpleArray<User> simpleArray = new SimpleArray<>(5);



    @Override
    public void add(User obj) {
        this.simpleArray.add(obj);
    }

    @Override
    public void update(User obj, int index) {
        this.simpleArray.update(obj, index);
    }
    @Override
    public void delete(int index){
        this.simpleArray.delete(index);
    }

    @Override
    public  User get(int index){
        return this.simpleArray.get(index);
    }

}

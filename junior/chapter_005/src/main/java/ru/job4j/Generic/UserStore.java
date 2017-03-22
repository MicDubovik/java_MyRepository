package ru.job4j.Generic;

public class UserStore extends Base {

    SimpleArray<String> simpleArray = new SimpleArray<>(10);

    public void add(String id){

        this.simpleArray.add(id);
    }

    public void delete(String id){

    }

}

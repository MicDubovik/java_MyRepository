package ru.job4j.MultiThreading.NonBlock;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockCache {

    private ConcurrentHashMap<Integer,User>  map = new ConcurrentHashMap<>();

    public void add(int num ,User user){
        this.map.put(num,user);
    }

    public void removeByObject(User user){
        this.map.remove(user);
    }

    public void removeByKey(int key){
        this.map.remove(key);
    }

    public void update(int key ,User user)throws Exception {

        if (this.map.get(key).getVersion()==user.getVersion()){
            user.changeVersion();
            this.map.replace(key,user);
        }else {
             throw new OplimisticException("Exeption replace! Version is");
        }
    }

}

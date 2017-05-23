package ru.job4j.MultiThreading.NonBlock;

import java.util.concurrent.ConcurrentHashMap;

/**
 * NonBlockCache.
 */
public class NonBlockCache {
    /**
     * ConcurrentHashMap<Integer,User>.
     */
    private ConcurrentHashMap<Integer,User>  map = new ConcurrentHashMap<>();

    /**
     * Add.
     * @param num
     * @param user
     */
    public void add(int num ,User user){
        this.map.put(num,user);
    }

    /**
     * Remove by Object.
     * @param user
     */
    public void removeByObject(User user){
        this.map.remove(user);
    }

    /**
     * remove By Key.
     * @param key
     */
    public void removeByKey(int key){
        this.map.remove(key);
    }

    /**
     * update.
     * @param key
     * @param user
     * @throws Exception
     */
    public void update(int key ,User user)throws Exception {

        if (this.map.get(key).getVersion()==user.getVersion()){
            user.changeVersion();
            this.map.replace(key,user);
        }else {
             throw new OplimisticException("Exeption replace! Version is");
        }
    }

}

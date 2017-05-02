package ru.job4j.MultiThreading.Wait.ThreadPool2;

import java.util.ArrayList;
import java.util.List;

public class Worker implements Runnable {
    /**
     * Field for contact with buffer(QueueTasks).
     */
    QueueTasks asks;

    /**
     * List for control executed tasks.
     */
    List<Integer> integerList = new ArrayList<>();

    /**
     * Construcnor.
     * @param asks
     */
    public Worker(QueueTasks asks) {

        this.asks = asks;
    }

    public boolean worker(){
        if(asks.getTempAsks().size()==0){
            return false ;
        }else return true;
    }


    @Override
    public void run() {
        while (!asks.flag || asks.getTempAsks().size()>0) {

            boolean flag = asks.get();
            if (flag) {
                integerList.add(asks.getTask());

            }
        }
    }
}

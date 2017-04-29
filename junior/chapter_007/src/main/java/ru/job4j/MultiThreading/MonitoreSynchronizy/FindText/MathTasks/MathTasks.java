package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.MathTasks;

import java.util.concurrent.Callable;

public class MathTasks implements Callable<Integer> {

    private int x;
    private int y;
    private int operation;

    public MathTasks(int x, int y, int operation) {
        this.x = x;
        this.y = y;
        this.operation = operation;
    }

    public int sum(){
        return this.x+this.y;
    }
    public int dev(){
        return this.x/this.y;
    }
    public int sub(){
        return this.x - this.y;
    }




    @Override
    public Integer call() throws Exception {
       if (this.operation==0){
           return sum();
       }else if (this.operation==1){
           return dev();
       }else if(this.operation==2){
           return sub();
       }else
           return 0;
    }
}

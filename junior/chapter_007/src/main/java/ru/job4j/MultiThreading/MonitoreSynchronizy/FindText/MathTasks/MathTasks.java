package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.MathTasks;

import java.util.concurrent.Callable;

/**
 * MathTasks.
 */
public class MathTasks implements Callable<Integer> {
    /**
     * X.
     */
    private int x;
    /**
     * Y.
     */
    private int y;
    /**
     * operation.
     */
    private int operation;

    /**
     * Constructor.
     * @param x
     * @param y
     * @param operation
     */
    public MathTasks(int x, int y, int operation) {
        this.x = x;
        this.y = y;
        this.operation = operation;
    }

    /**
     * sum.
     * @return
     */
    public int sum(){
        return this.x+this.y;
    }

    /**
     * dev.
     * @return
     */
    public int dev(){
        return this.x/this.y;
    }

    /**
     * sub.
     * @return
     */
    public int sub(){
        return this.x - this.y;
    }

    /**
     * call.
     * @return
     * @throws Exception
     */
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

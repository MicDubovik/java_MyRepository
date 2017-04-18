package ru.job4j.MultiThreading.JMM;

/**
 * SubClass .
 */
public class SubClass {
    /**
     * Field num.
     */
    private int num ;

    /**
     * Method for calculate num.
     * @return
     */
    public int sum (){
        for (int i = 0; i < 10; i++) {
            num++;
        }
        return num;
    }
}

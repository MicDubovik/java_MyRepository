package ru.job4j.Calculator;

public class EngineerCalc {

    double result;

    public void sinus(double first ,double second){

        if (second != 0) {
            this.result = first / second;
        } else {
            this.result = 0;
        }
    }
    public void  cosinus(double first, double second){
        if (second != 0) {
            this.result = second / first;
        } else {
            this.result = 0;
        }

    }

    public double getResult() {
        return result;
    }


}

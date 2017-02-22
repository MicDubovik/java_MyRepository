package ru.job4j;

public class Max {


    String result = "";




    public String max(int value1, int value2){
        if (  value1> value2){
             this.result = "first > second" ;
        }
        else if ( value1< value2){
            this.result ="first < second";
        }
        else {
            this.result = "max.value1 = max.value2";
        }
        return result;
    }


}

/**
 * Created by Katy on 18.02.2017.
 */
public class Calculator {
    /**
     * результат вычисления
     */
    private double result ;


    /**
     * Получить результат вычисления
     * @return результат вычисления
     */

    public double getResult() {
        return this.result;
    }

    /**
     * Суммируем аргументы
     *
     */

    public void add(int first , int second){

            this.result =first+second;
    }

    /**
     * Вычитаем аргументы
     */
    public void sub(int first , int second){

            this.result =first-second;

    }

    /**
     * Умножаем аргументы
     *
     */
    public void mul(int first , int second){

            this.result=(double)first*second;

    }

    /**
     * Делим параметры
     *
     */
    public void dev(int first , int second){

            this.result=(double)first/second;

    }


    /**
     * Очистить результаты вычисления
     *
     */
    public void cleanResult(){
        this.result=0;
    }

}

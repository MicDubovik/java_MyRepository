package ru.job4j.Bank;

import java.util.Random;

/**
 * Class describe  Bank
 */

public class Bank {
    /**
     * Array visitors in Bank today.
     */
    private Visitors[] visitors = new Visitors[15];


    /**
     * Method add visitors and their time in array.
     *
     * @return array visitors.
     */
    public Visitors[] addVisitors() {
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            int randomInTime = (random.nextInt(11) + 8);
            int randomOutTime = 0;

            do {
                randomOutTime = (random.nextInt(12) + 8);
            } while (randomOutTime <= randomInTime);

            this.visitors[i] = new Visitors();
            this.visitors[i].setIn(randomInTime);
            this.visitors[i].setOut(randomOutTime);
            this.visitors[i].addFlag();
        }
        return visitors;
    }

    /**
     * Method sum  flag when visitors was inside Bank.
     *
     * @param visitors
     * @return
     */
    public int[] sumFlag(Visitors[] visitors) {
        int[] sum  = new int[21];
        sum[0] = 0;
        for (Visitors v : visitors) {
            for (int i = 0; i < 21; i++) {
                if (v.getLongTime()[i] == 1) {
                    sum[i] += 1;
                }
            }
        }
        return sum ;
    }

    /**
     * Main method for start.
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Create Bank.
         */
        Bank bank = new Bank();
        /**
         * Create array and sum time when visitors was inside Bank.
         */
        int[] time = bank.sumFlag(bank.addVisitors());
        int hours = 0;

        int i = 0;
        /**
         * Show all visitors and their time inside Bank.
         */
        for (Visitors arg : bank.addVisitors()) {
            System.out.println("Посетитель " + i + ": Time in= " + arg.getIn() + "\t" + "Time out= " + arg.getOut());
            int h = 0;
            for (int s : arg.getLongTime()) {

                System.out.println("Time "+h+"-00 - "+(h+1)+"-00  " + s);
                h++;
            }
            i++;
        }
        /**
         * Show count visitors in Bank.
         */
        for (int num : time) {
            System.out.println("Количество посетителей в банке (c " + hours + "-00 до "+(hours+1)+"-00): " + num);
            hours++;
        }

    }

}

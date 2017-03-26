package ru.job4j.Bank;

/**
 * Class describe visitors .
 */
public class Visitors {
    /**
     * in -   when visitor go in Bank.
     */
    private int in;
    /**
     * out - when visitor go out from Bank.
     */
    private int out;
    /**
     * Array - flag . Hours when visitor was inside in Bank.
     */
    private int[] longTime = new int[21];

    public Visitors() {

    }

    /**
     * Method add 1 for hours when visitor was inside in Bank.
     *
     * @return
     */
    public int[] addFlag() {
        for (int i = 0; i < this.out; i++) {
            if (i >= this.in && i <= this.out) {
                longTime[i] = 1;
            } else {
                longTime[i] = 0;
            }
        }
        return longTime;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        if (in >= 8 && in <= 20){
            this.in = in;
        }

    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        if (out <= 20 && out >= 8)
            this.out = out;
    }

    public int[] getLongTime() {
        return longTime;
    }

}

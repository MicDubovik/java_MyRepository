package ru.job4j.Test;

/**
 * Context.
 */
public class Context {
    /**
     * Reference to the strategy.
     */
    private Strategy strategy;

    /**
     * Constructor.
     * @param strategy
     */
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * Execute.
     * @param num1
     * @param num2
     * @return
     */
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}

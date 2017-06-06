package ru.job4j.counter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Тест для нахождения суммы четных чисел .
 */
public class CounterTest {
    @Test
    public void add() {
        Counter counter = new Counter();
        int result = counter.add(1,10);

        assertThat(result,is(30));
    }

}
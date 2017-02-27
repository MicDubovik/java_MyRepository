package ru.job4j.factorial;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест Факториала
 */
public class FactorialTest {
    /**
     * Тест метода рекурсивного
     *
     */
    @Test
    public void methodfactorial()   {

        Factorial fact = new Factorial();

        int result = fact.methodfactorial(5);
        assertThat(result,is(120));

    }

    /**
     * Тест метода цикла
     */

    @Test
    public void methodfactorial2()   {
        Factorial fact2 = new Factorial();
        int result = fact2.methodfactorial2(6);
        assertThat(result,is(720));

    }

}
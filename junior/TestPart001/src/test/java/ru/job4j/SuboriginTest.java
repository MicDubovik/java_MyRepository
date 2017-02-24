package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Suborigin
 */
public class SuboriginTest {
    /**
     * Тестируем 1-й вариант
     * @throws Exception
     */
    @Test
    public void compareSubFromOrig() throws Exception {

        Suborigin suborigin = new Suborigin();
        boolean result = suborigin.compareSubFromOrig("Hi girl!", "ir");
        assertThat(result, is(true));


    }
    /**
     * Тестируем 2-й вариант
     * @throws Exception
     */

    @Test
    public void comp2() throws Exception {
        Suborigin suborigin = new Suborigin();
        boolean result = suborigin.comp2("Hi girl!", "ir");
        assertThat(result, is(true));

    }
    /**
     * Тестируем 3-й вариант
     * @throws Exception
     */

    @Test
    public void comp3() throws Exception {
        Suborigin suborigin = new Suborigin();
        boolean result = suborigin.comp3("Hi girl!", "ir");
        assertThat(result, is(true));


    }
}
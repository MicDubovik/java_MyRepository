package ru.job4j.Iterator.IteratorMy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleNumberTest {

    /**
     * Tests for override Iterator for simple number.
     */
    @Test
    public void ChekNextMethodForSimpleNumber() {

        int[] values = new int[]{11, 28, 31, 45, 53};
        SimpleNumber sn = new SimpleNumber(values);

        sn.next();


        int result = (Integer) sn.next();

        assertThat(result, is(31));
    }

    @Test
    public void ChekHasNextMethodForSimpleNumber() {

        int[] values = new int[]{11, 28, 31, 45, 53};
        SimpleNumber sn = new SimpleNumber(values);

        sn.next();
        sn.hasNext();
        sn.next();
        sn.next();

        boolean result =  sn.hasNext();

        assertThat(result, is(false));
    }


}
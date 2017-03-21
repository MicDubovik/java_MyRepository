package ru.job4j.Iterator.IteratorMy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IteratorForEvenTest {

    @Test
    public void testMyIteratorNextEven(){
        int[] values = new int[]{1,2,3,4,5};
        IteratorForEven ife = new IteratorForEven(values);

        ife.next();


        int result = (Integer) ife.next();

        assertThat(result,is(4));
    }

}
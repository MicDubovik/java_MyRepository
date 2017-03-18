package ru.job4j.CollectionFramework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {

    @Test
    public void toListTest() {


        int[][] array2 = new int[][]{
                {1, 2, 3},
                {1, 2, 3}};
        ConvertList list = new ConvertList();
        List<Integer> integerList = new ArrayList<>();
        List<Integer> result = list.toList(array2);
        List<Integer> was = new ArrayList<>();
        was.add(1);
        was.add(2);
        was.add(3);
        was.add(1);
        was.add(2);
        was.add(3);

        assertThat(result, is(was));
    }

    @Test
    public void toArrayTest() {

        ConvertList list2 = new ConvertList();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        int[][] result = list2.toArray(integerList, 2);

        int[][] was = {{1, 2, 3}, {1, 2, 3}};

        assertThat(result, is(was));
    }

    @Test
    public void convertTest() {
        ConvertList list1 = new ConvertList();
        List<int[]> list2 = new ArrayList<>();
        list2.add(new int[]{1, 2});
        list2.add(new int[]{3, 4, 5, 6});
        List<Integer> result = list1.convert(list2);
        int[] array = new int[result.size()];
        int i=0;
        for (Integer integer : result) {
           array[i]=integer;
           i++;
        }
        int[] wait = new int[]{1, 2, 3, 4, 5, 6};

        assertThat(array, is(wait));
    }

}
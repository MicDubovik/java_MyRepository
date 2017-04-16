package ru.job4j.CodePhone;

import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CodeSplitTest {
    @Test
    public void cutMyArrayStringsOnStrings() {

        String[] string = {"K1/SK1/SSK1"};

        CodeSplit split = new CodeSplit();

        split.cutArray(string);

        TreeSet<String> was = split.sortedSet;

        TreeSet<String> result = new TreeSet<>();
        String string1 = "K1";
        String string2 = "K1/SK1";
        String string3 = "K1/SK1/SSK1";

        result.add(string1);
        result.add(string2);
        result.add(string3);

        assertThat(result, is(was));
    }
    @Test
    public void reverseList(){
        CodeSplit split = new CodeSplit();

        TreeSet<String> result = new TreeSet<>();
        String s1 = "K1";
        String s2 = "K1/SK1";
        String s3 = "K2";
        result.add(s3);
        result.add(s1);
        result.add(s2);

        split.sortedSet.add(s1);
        split.sortedSet.add(s2);
        split.sortedSet.add(s3);


        TreeSet<String> was = split.reverse(split.sortedSet);

        assertThat(result, is(was));


    }
}
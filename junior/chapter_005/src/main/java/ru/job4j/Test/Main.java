package ru.job4j.Test;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
        String s1 = "K1";
        String s2 = "K1/SK1";
        String s3 = "K2";
        result.add(s3);
        result.add(s1);
        result.add(s2);

        System.out.println(result);
    }
}
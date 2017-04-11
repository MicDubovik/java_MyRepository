package ru.job4j.MultiThreading.Threads;

public class Arguments  {

  private   String string = " The following    example    brings together some of the concepts of this section";

    public String getString() {
        return string;
    }

    public int wordCount(String string) {
        int result = 0;
        String newstr[] = string.split("\\s* \\s*");

        return newstr.length;
    }

    public int spaceCount(String string) {
        char[] chArray = string.toCharArray();
        int result = 0;
        for (int i = 0; i < chArray.length; i++) {
            if (Character.isWhitespace(chArray[i])) {
                result++;
            }
        }
        return result;
    }



}

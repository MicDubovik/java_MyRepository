package ru.job4j.MultiThreading.Threads;

public class Arguments {
    /**
     * Input string.
     */
    String string = " The following    example    brings together some of the concepts of this section";

    /**
     * Method for count words.
     * @param string
     * @return
     */
    public int wordCount(String string) {

        int result = 1;

        String newstr = string.trim();

        while (newstr.contains(" ")) {
          newstr =  newstr.substring(0, newstr.lastIndexOf(" "));

          if (newstr.endsWith(" ")){

          } else {
              result++;
          }

        }
        return result;
    }

    /**
     * Method for count spaces.
     * @param string
     * @return
     */
    public int spaceCount(String string) {

        int result = 0;

        char[] chArray = string.toCharArray();

        for (int i = 0; i < chArray.length; i++) {
            if (Character.isWhitespace(chArray[i])) {
                result++;
            }

        }
        return result;
    }
}

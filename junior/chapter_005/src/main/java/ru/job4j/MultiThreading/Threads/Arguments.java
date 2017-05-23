package ru.job4j.MultiThreading.Threads;

/**
 * Arguments.
 */
public class Arguments {
    /**
     * String.
     */
    private String string = " The following    example    brings together some of the concepts of this section";

    /**
     * Get.
     *
     * @return
     */
    public String getString() {
        return string;
    }

    /**
     * wordCount.
     *
     * @param string
     * @return
     */
    public int wordCount(String string) {

        int result = 0;
        String[] newstr = null;

        newstr = string.split("\\s* \\s*");

        return newstr.length;
    }

    /**
     * spaceCount.
     *
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

package ru.job4j.IsNumber;

import java.io.InputStream;
import java.util.Scanner;

/**
 * IsNumber.
 */
public class IsNumber {


    public boolean isNumber(InputStream in) {

        boolean result = false;
        try {

            System.out.println("Enter your number");
            Scanner sc = new Scanner(System.in);
            result = false;

            if (Integer.parseInt(sc.nextLine()) % 2 == 0) {
                result = true;
            }


        } catch (Exception ex) {
            ex.getMessage();
        }
        return result;
    }
}

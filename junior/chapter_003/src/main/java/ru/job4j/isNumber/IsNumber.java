package ru.job4j.IsNumber;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Katy on 09.03.2017.
 */
public class IsNumber {
    public class Test003 {

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
}
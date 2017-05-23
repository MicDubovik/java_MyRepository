package ru.job4j.paint;

/**
 * Отрисовка пирамиды символом "^"
 */
public class Paint {

    StringBuilder builder = new StringBuilder();


    /**
     * Мотод отрисовки пирамиды
     * @param h
     * @return
     */

   public String piramid(int h){
       int k=1;

       for (int i = 0; i < k*h; i++)
       {

           for (int j = 1; j < h; j++)
           {
               builder.append(" ");
           }

           for (int x = 0; x < k; x++)
           {
               builder.append("^");
           }
           h -= 1;
           k += 2;
          builder.append("\n");

       }
       return builder.toString();
   }
}

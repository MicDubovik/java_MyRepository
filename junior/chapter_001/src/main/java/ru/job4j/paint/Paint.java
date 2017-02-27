package ru.job4j.paint;

/**
 * Отрисовка пирамиды символом "^"
 */
public class Paint {

    StringBuilder builder = new StringBuilder();
    String simbol= "^";
    String empty = " ";
    String move ="\n" ;
    int num =1;

    /**
     * Мотод отрисовки пирамиды
     * @param h
     * @return
     */

   public String piramid(int h){

       for (int i = 0; i < num*h; i++)
       {

           for (int j = 1; j < h; j++)
           {
               builder.append(empty);
           }

           for (int x = 0; x < num; x++)
           {
               builder.append(simbol);
           }
           h -= 1;
           num += 2;
          builder.append(move);

       }
       return builder.toString();
   }
}

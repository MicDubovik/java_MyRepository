package ru.job4j.Sort;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileSort.
 */
public class FileSort implements ISort {
    /**
     * sort.
     * @param source
     * @param distance
     * @throws IOException
     */
    @Override
    public void sort(File source, File distance) throws IOException {
        try {FileReader reader = new FileReader(source) ;

            StringBuilder builder = new StringBuilder();
            /**
             * читаем посимвольно и добавляем символы в builder .
              */

            int c;

            while ((c = reader.read()) != -1) {

                builder.append((char) c);
            }
            /**
             * Создаем два массива ,
             * в один записываем строку до перевода строки,
             * в другой - получившуюся строку , отрезав получившуюся строку до переноса.
             */

            int i = 1;
            String[] arrstr = new String[10];
            String[] arrstrlong = new String[10];
            do {

                if (i < 2) {
                    arrstr[0] = builder.substring(0, builder.indexOf("\n"));
                    arrstrlong[0] = builder.substring(builder.indexOf("\n") + 1);
                }

                if (arrstrlong[i - 1].indexOf("\n") != -1)
                    arrstr[i] = arrstrlong[i - 1].substring(0, arrstrlong[i - 1].indexOf("\n"));
                arrstrlong[i] = arrstrlong[i - 1].substring(arrstrlong[i - 1].indexOf("\n") + 1);
                i++;
            } while (arrstrlong[i - 1].indexOf("\n") != -1);

            int num = 0;

            for (int j = 0; j <arrstr.length ; j++) {

                if (arrstr[j]== null){
                      num++;
                }
            }
            /**
             * отрезаем null ячейки из полученного массива
             */
             String[] newArrayWithoutNull = new String[arrstr.length-num];
            for (int z = 0; z < newArrayWithoutNull.length; z++) {
                newArrayWithoutNull[z]=arrstr[z];
            }
            /**
             * Сортируем массив по длинне символов.
             */
                for (int k = 0; k < newArrayWithoutNull.length - 1; k++) {
                    for (int w = k+1 ; w < newArrayWithoutNull.length; w++) {
                        if (newArrayWithoutNull[k].length() > newArrayWithoutNull[w].length()) {
                            String buffer = newArrayWithoutNull[k];
                            newArrayWithoutNull[k] = newArrayWithoutNull[w];
                            newArrayWithoutNull[w] = buffer;
                        }
                    }
                }

            /**
             * Создаем поток для записи наших данных
             * и передаем в поток наш массив,указываем имя нового файла,и записываем данные
             * в файл
             */
            FileWriter writer = new FileWriter(distance);

            for (String s : newArrayWithoutNull) {
                System.out.println(s);
               writer.write(s);
               writer.write("\n");

            }
            writer.flush();
            writer.close();


        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    /**
     * main.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileSort newfile = new FileSort();

        File source =new File("/TestDir/testdir2/file1.txt") ;
        File distance =new File("/TestDir/testdir2/file2.txt");

        newfile.sort(source,distance);

    }

}

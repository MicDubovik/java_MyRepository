package ru.job4j.turnArray;

/**
 * Задание перевернуть на 90гр. в двухмерный массив.
 */
public class TurnArray {

    /**
     * Метод поворота массива
     * @param array
     * @return
     */


    public int[][] methodTurn(int [][] array){
        int size =array.length;
        for (int k=0; k<size/2; k++)
        {
            for (int j=k; j<size-1-k; j++)
            {
                int tmp = array[k][j];
                array[k][j] = array[j][size-1-k];
                array[j][size-1-k] = array[size-1-k][size-1-j];
                array[size-1-k][size-1-j] = array[size-1-j][k];
                array[size-1-j][k] = tmp;
            }
        }
        return array ;
    }
}

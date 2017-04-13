package ru.job4j.Test;

public class Main {


    public static void main(String[] args) {
//
//       List<Integer> integerList = new ArrayList<>();
//        List<Integer> integerList2 = new ArrayList<>();
//
//
//
//        Map<String, List<Integer>> listMap = new HashMap<>();
//
//        String string = "book-1";
//        String string1 = "book-2";
//        String string2 = "book-3";
//
//        Main main = new Main();
//
//        integerList.add(1);
//        integerList.add(2);
//        integerList.add(3);
//        integerList.add(4);
//
//        integerList2.add(5);
//        integerList2.add(6);
//        integerList2.add(7);
//        integerList2.add(8);
//
//        listMap.put(string,integerList);
//        listMap.put(string1,integerList2);
//
//        if (listMap.containsKey(string)){
//            listMap.get(string).add(9);
//        }
//
//        for (Map.Entry<String, List<Integer>> stringListEntry : listMap.entrySet()) {
//            System.out.println(stringListEntry);
//        }

        int[] array = {1, 2, 3, 4, 5, 8, 2, 3, 4, 1};

        for (int i = 0; i < array.length; i++) {
            int tmp =array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                      tmp = tmp + array[j];
                    array[j] = 0;
                }
            }
            array[i]=tmp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}

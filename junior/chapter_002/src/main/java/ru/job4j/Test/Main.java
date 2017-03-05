package ru.job4j.Test;

 class App {
     static int dev(){
      int[] x = new int[2];
      int y = x[10];
      return y;
     }
    public static void main(String[] args) {
        try {
            dev();
            throw new Exception();
        } catch (Throwable e) {
            System.out.println("ошибка");
        }
    }
}
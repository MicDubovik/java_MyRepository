package ru.job4j.MultiThreading.MonitoreSynchronizy.UserStorage;

/**
 * Main.
 */
public class Main {
    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {


        User user1 = new User(400000);
        User user2 = new User(400000);

        UserStorage storage = new UserStorage();


        storage.getUserList().add(user1);
        storage.getUserList().add(user2);

        int result = user1.getAmount() + user2.getAmount();

        for (int i = 0; i < 1000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean flag = true;
                    long start = System.currentTimeMillis();
                    while (user2.getAmount() > 0 && flag) {
                        long end = System.currentTimeMillis();

                        flag = storage.transfer(user1, user2, 7);
                        if (end - start > 30) {
                            return;
                        }

                    }
                }

            }).start();

        }

        for (int i = 0; i < 1000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean flag = true;
                    long start2 = System.currentTimeMillis();
                    while (user1.getAmount() > 0 && flag) {
                        long end2 = System.currentTimeMillis();

                        flag = storage.transfer(user2, user1, 3);
                        if (end2 - start2 > 30) {
                            return;
                        }

                    }
                }

            }).start();

        }


        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Amount user1 :" + user1.getAmount());
        System.out.println("Amount user2 :" + user2.getAmount());

        int endRusult = user1.getAmount() + user2.getAmount();
        if (result == endRusult) {
            System.out.println("Operation - validate !!!");

        } else {
            System.out.println("Operation - wrong !!!!!!!!!!!!");
        }

    }

}

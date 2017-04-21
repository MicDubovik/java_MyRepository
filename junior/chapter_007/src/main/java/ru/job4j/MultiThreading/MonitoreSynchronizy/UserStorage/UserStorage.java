package ru.job4j.MultiThreading.MonitoreSynchronizy.UserStorage;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    /**
     * List users.
     */
    private List<User> userList = new ArrayList<>();

    /**
     * Get users.
     * @return
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Method for transfer money.
     * @param toUser
     * @param fromUser
     * @param value
     * @return
     */
    public boolean transfer(User toUser, User fromUser, int value) {

        boolean flag = true;
        if (fromUser.getAmount() >= value) {
            toUser.addMoney(value);
            fromUser.devMoney(value);
            System.out.println("Amount UserSender : " + fromUser.getAmount());
            System.out.println("Amount UserRecipient : " + toUser.getAmount());
        } else {
            flag = false;
            System.out.println("Not enough money");
        }

        return flag;
    }
}



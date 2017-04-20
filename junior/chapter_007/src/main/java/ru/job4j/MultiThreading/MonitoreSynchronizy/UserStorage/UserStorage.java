package ru.job4j.MultiThreading.MonitoreSynchronizy.UserStorage;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private List<User> userList = new ArrayList<>();


    public List<User> getUserList() {
        return userList;
    }

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



package ru.job4j.MapForBank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    Map<User, List<Account>> userListMap = new HashMap<>();

    List<User> listUsers = new ArrayList<>();


    public void addUser(User user) {
        listUsers.add(user);
        fill(this.listUsers);
    }

    public void deleteUser(User user) {
        listUsers.remove(user);
    }

    public void addAccountToUser(User user, Account account) {


           int index =  this.listUsers.indexOf(user);

           this.listUsers.get(index).getAccounts().add(account);

           fill(this.listUsers);
    }

    public void deleteAccountFromUser(User user, Account account) {
        user.getAccounts().remove(account);
    }

    public List<Account> getUserAccounts(User user) {
        List<Account> allAccount = user.getAccounts();
        return allAccount;
    }


    public Map<User, List<Account>> fill(List<User> users) {

        for (int i = 0; i < users.size(); i++) {
            userListMap.put(users.get(i), users.get(i).getAccounts());
        }
        return userListMap;
    }

    public void showAllUsers(List<User> users){

        for (User user : users) {
            user.showUser();
        }
    }

    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, int value) {
        boolean flag = false;
        if (srcAccount.getValue()>=value && dstAccount !=null ){
            dstAccount.setValue(dstAccount.getValue() + value);
            srcAccount.setValue(srcAccount.getValue() - value);
             flag = true;
            System.out.println("Your transaction is OK !!!");
        } else {

            System.out.println("Your transaction is False !!!");
        }
        return flag;
    }
}

package ru.job4j.MapForBank;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {

        Bank bank= new Bank();

        List<Account> accountList1 = new ArrayList<>();
        accountList1.add(new Account(100000,10001));
        accountList1.add(new Account(200000,10002));
        accountList1.add(new Account(300000,10003));

        List<Account> accountList2 = new ArrayList<>();
        accountList2.add(new Account(100000,20001));
        accountList2.add(new Account(200000,20002));


        List<Account> accountList3 = new ArrayList<>();
        accountList3.add(new Account(100000,30001));
        accountList3.add(new Account(200000,30002));
        accountList3.add(new Account(300000,30003));
        accountList3.add(new Account(300000,30004));

        List<Account> accountList4 = new ArrayList<>();
        accountList4.add(new Account(100000,40001));


        bank.addUser(new User("Mik", "1111",accountList1)) ;
        bank.addUser(new User("Paul","3333",accountList2));
        bank.addUser(new User("Andrey","2222",accountList3));
        bank.addUser(new User("John","4444",accountList4));

        for (User user : bank.listUsers) {
            System.out.println("Name :"+user.getName()+", Quantity account :"+user.getAccounts().size());
        }

    }
}

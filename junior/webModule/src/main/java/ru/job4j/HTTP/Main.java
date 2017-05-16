package ru.job4j.HTTP;

import ru.job4j.HTTP.DbConnect.StartConnect;
import ru.job4j.HTTP.DbConnect.User;

import java.io.PrintWriter;

/**
 * Created by Katy on 16.05.2017.
 */
public class Main {

    StartConnect connect = new StartConnect();

    public void doget(){

        this.connect.startToDB();
        this.connect.getInitDB().getAllUsers();
        for (User user :this.connect.getInitDB().getUserList()) {
            System.out.println(user);
        }

        this.connect.close();

    }

    public void dopost(String name,String login,String email){

        this.connect.startToDB();
        this.connect.getInitDB().addUser(name,login,email);
        this.connect.close();
    }

    public void doput(){
        String name = "IvJohn";
        String login =  "vano" ;


        this.connect.startToDB();
        this.connect.getInitDB().updateUserName(name,login);
        this.connect.close();
    }

    public void dodelete(){

        String login = "michyy";


        this.connect.startToDB();
        this.connect.getInitDB().deleteUserByLogin(login);
        this.connect.close();
    }
    public static void main(String[] args) {

        Main main = new Main();
//        main.dopost("Michael","michyy","michyy@mail.ru");
//        main.dopost("Ivan","vano","vano@mail.ru");
//        main.dopost("Petr","apetr","petr@mail.ru");

//         main.doget();
//
//        main.doput();
//        main.doget();
//
//        main.dodelete();
//        main.doget();

    }
}

package ru.job4j.HTTP;

import ru.job4j.HTTP.DbConnect.ConnectionPool;
import ru.job4j.HTTP.DbConnect.InitDB;
import ru.job4j.HTTP.DbConnect.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Katy on 16.05.2017.
 */
public class Main {

    InitDB initDB = new InitDB();


    public Main() throws SQLException, ClassNotFoundException {
    }


    public void doget() throws SQLException {

        this.initDB.getPool().getConnection();
        this.initDB.getAllUsers();
        for (User user : this.initDB.getUserList()) {
            System.out.println(user);
        }

        this.initDB.getPool().getConnection().close();


    }

    public void dopost(String name, String login, String email) throws SQLException {

        this.initDB.getPool().getConnection();
        this.initDB.addUser(name, login, email);
        this.initDB.getPool().getConnection().close();
    }

    public void doput() throws SQLException {
        String name = "Ivan";
        String login = "vano";

        this.initDB.getPool().getConnection();
        this.initDB.updateUserName(name, login);
        this.initDB.getPool().getConnection().close();
    }

    public void dodelete() throws SQLException {

        String login = "REjapetr";

        this.initDB.getPool().getConnection();
        this.initDB.deleteUserByLogin(login);
        this.initDB.getPool().getConnection().close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Main main = new Main();
//        main.dopost("Vhichael", "vhayy", "vshhahyy@mail.ru");
//        main.dopost("AShan", "AShno", "Ashno@mail.ru");
//        main.dopost("REPjetr", "REjapetr", "prjeetr@mail.ru");

//         main.doget();

//        main.doput();
//        main.doget();
//
//        main.dodelete();
//        main.doget();

    }
}

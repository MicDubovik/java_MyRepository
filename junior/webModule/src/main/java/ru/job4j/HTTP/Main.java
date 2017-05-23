package ru.job4j.HTTP;


import ru.job4j.HTTP.DbConnect.InitDB;
import ru.job4j.HTTP.DbConnect.User;


import java.sql.SQLException;

/**
 * Main.
 */
public class Main {
    /**
     * Init to db.
     */
    InitDB initDB = new InitDB();

    /**
     * Constructor.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Main() throws SQLException, ClassNotFoundException {

    }

    /**
     * DoGet.
     * @throws SQLException
     */
    public void doget() throws SQLException {


        this.initDB.getAllUsers();
        for (User user : this.initDB.getUserList()) {
            System.out.println(user);
        }

    }

    /**
     * DoPost.
     * @param name
     * @param login
     * @param email
     * @throws SQLException
     */
    public void dopost(String name, String login, String email) throws SQLException {

        this.initDB.addUser(name, login, email);

    }

    /**
     * DoPut.
     * @throws SQLException
     */
    public void doput() throws SQLException {
        String name = "Ivanos";
        String login = "vano";

        this.initDB.updateUserName(name, login);

    }

    /**
     * DoDelete.
     * @throws SQLException
     */
    public void dodelete() throws SQLException {

        String login = "REjapetr";

        this.initDB.deleteUserByLogin(login);

    }

    /**
     * main.
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Main main = new Main();
//        main.dopost("Vhichael", "vhayy", "vshhahyy@mail.ru");
//        main.dopost("AShan", "AShno", "Ashno@mail.ru");
//        main.dopost("REPjetr", "REjapetr", "prjeetr@mail.ru");

          main.doget();

//        main.doput();
//        main.doget();
//
//        main.dodelete();
//        main.doget();

    }
}

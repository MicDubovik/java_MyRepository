package ru.job4j.Servlet3.DbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Katy on 07.05.2017.
 */
public class InitDB {
    /**
     * Table name.
     */
    private String tablename;
    /**
     * Preparedstatment.
     */
    PreparedStatement ps = null;
    /**
     * DB.
     */
    Db db;

    /**
     * Structure table.
     */
    Structure structure = new Structure("name","login","email");
    /**
     * List users.
     */
    List<User> userList = new CopyOnWriteArrayList<>();

    /**
     * Constructor.
     * @param dbName
     * @param host
     * @param port
     * @param user
     * @param pass
     * @param tablename
     */
    public InitDB(String dbName, String host, String port, String user, String pass,String tablename) {


        this.db = new Db(dbName, host, port, user, pass);
        this.tablename=tablename;
    }

    /**
     * getDB
     * @return
     */
    public Db getDb() {
        return db;
    }

    /**
     * Get List users.
     * @return
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Create connection.
     */
    public void createConnection() throws ClassNotFoundException {

        this.db.initProperties();
        this.db.connectToBD();


    }

          // для создания таблицы
//    public void createTable(String tableName) {
//
//        this.tablename = tableName;
//        String createTable = "CREATE TABLE " + tableName +
//                " ( id Serial PRIMARY KEY ,
//                name VARCHAR (30),
//                login VARCHAR (40) UNIQUE ,
//                email VARCHAR (50) UNIQUE ,
//                time TIMESTAMP DEFAULT CURRENT_TIMESTAMP )";
//        try {
//
//            Statement stmt = db.getConnection().createStatement();
//            stmt.execute(createTable);
//        } catch (SQLException e) {
//            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
//        }
//    }

    public void addUser(String name, String login,String email) {
        String query = "INSERT  INTO tableName ("+structure.getName()+","+structure.getLogin()+","+structure.getEmail()+") VALUES(?,?,?)";
        String newQuery = query.replace("tableName", this.tablename);
        try {
            this.ps = this.db.getConnection().prepareStatement(newQuery);

            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, email);

            ps.execute();
        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
        }
    }

    public void updateUserName(String name,String login) {

        String update = "UPDATE  tableName SET "+structure.getName()+" =? WHERE login=?";
        String newQuery = update.replace("tableName", this.tablename);

        try {
            this.ps = this.db.getConnection().prepareStatement(newQuery);

            ps.setString(1, name);
            ps.setString(2, login);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
        }
    }

    public ResultSet getAllUsers() {
        ResultSet resultSet = null;
        String query = "SELECT * FROM tableName";
        String newQuery = query.replace("tableName", this.tablename);
        try {
            this.ps = this.db.getConnection().prepareStatement(newQuery);

            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
        }
        showResult(resultSet);
        return resultSet;
    }

    public void deleteUserByLogin(String login) {
        String query = "DELETE  FROM tableName WHERE "+structure.getLogin()+"=?";
        String newQuery = query.replace("tableName", this.tablename);

        try {
            this.ps = this.db.getConnection().prepareStatement(newQuery);

            ps.setString(1, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
        }
    }


    public void showResult(ResultSet res) {

        try {
            while (res.next()) {
                User user = new User();
                user.setId(res.getString("id"));
                user.setName(res.getString("name"));
                user.setLogin(res.getString("login"));
                user.setEmail(res.getString("email"));
                user.setDate(res.getString("date"));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n",e.getMessage());
        }

    }

}


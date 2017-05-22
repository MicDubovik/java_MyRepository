package ru.job4j.DbConnect;

import java.sql.Connection;
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
     * Pool.
     */
    ConnectionPool pool = new ConnectionPool();

    /**
     * Structure table.
     */
    Structure structure = new Structure("name", "login", "password","email");
    /**
     * List users.
     */
    List<User> userList = new CopyOnWriteArrayList<>();
    /**
     * Table name.
     */
    String tableName = "servlet";

    /**
     * Constructor
     */
    public InitDB() {
    }


    /**
     * Get List users.
     *
     * @return
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Get pool.
     *
     * @return
     */
    public ConnectionPool getPool() {
        return pool;
    }

    /**
     * Add user.
     *
     * @param name
     * @param login
     * @param email
     */
    public boolean addUser(String name, String login, String email,String password) {
        String query = "INSERT  INTO tableName (" + structure.getName() + "," + structure.getLogin() + "," + structure.getPassword() +"," + structure.getEmail()+") VALUES(?,?,?,?)";
        String newQuery = query.replace("tableName", this.tableName);
        boolean isexist = false;
        try (Connection conn = pool.getConnection();
             PreparedStatement ps = conn.prepareStatement(newQuery)) {


            ps.setString(1, name);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.setString(4, email);

            ps.execute();
        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n", e.getMessage());
            isexist=true;
        }
        return isexist;
    }

    /**
     * Update user.
     *
     * @param name
     * @param login
     */
    public void updateUserName(String name, String login) {

        String update = "UPDATE  tableName SET " + structure.getName() + " =? WHERE login=?";
        String newQuery = update.replace("tableName", this.tableName);

        try (Connection conn = pool.getConnection();
             PreparedStatement ps = conn.prepareStatement(newQuery)) {

            ps.setString(1, name);
            ps.setString(2, login);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n", e.getMessage());
        }
    }

    /**
     * Get all users.
     *
     * @return
     */
    public ResultSet getAllUsers() {
        ResultSet res = null;
        String query = "SELECT * FROM tableName";
        String newQuery = query.replace("tableName", this.tableName);
        try (Connection conn = pool.getConnection();
             PreparedStatement ps = conn.prepareStatement(newQuery)) {

            res = ps.executeQuery();

            while (res.next()) {
                User user = new User();
                user.setId(String.valueOf(res.getInt("id")));
                user.setName(res.getString("name"));
                user.setLogin(res.getString("login"));
                user.setPassword(res.getString("password"));
                user.setEmail(res.getString("email"));
                user.setDate(res.getString("date"));
                user.setRole( String.valueOf(res.getString("id_role")));

                userList.add(user);
            }

        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n", e.getMessage());
        }

        return res;
    }

    /**
     * Delete user by login.
     *
     * @param login
     */
    public void deleteUserByLogin(String login) {
        String query = "DELETE  FROM tableName WHERE " + structure.getLogin() + "=?";
        String newQuery = query.replace("tableName", this.tableName);

        try (Connection conn = pool.getConnection();
             PreparedStatement ps = conn.prepareStatement(newQuery)) {

            ps.setString(1, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n", e.getMessage());
        }
    }

    public boolean CheckPass(User user,String login,String password) {
        boolean exist =false;
        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            exist = true;
        }
        return exist;
    }

    public boolean isExist(String login, String password) {
        boolean exist = false;
        ResultSet res = null;
        User user = null;
        String query = "SELECT * FROM tableName WHERE login='" + login + "'";
        String newQuery = query.replace("tableName", this.tableName);
        try (Connection conn = pool.getConnection();
             PreparedStatement ps = conn.prepareStatement(newQuery)) {

            res = ps.executeQuery();

            while (res.next()) {

                user.setId(String.valueOf(res.getInt("id")));
                user.setName(res.getString("name"));
                user.setLogin(res.getString("login"));
                user.setPassword(res.getString("password"));
                user.setEmail(res.getString("email"));
                user.setDate(res.getString("date"));
                user.setRole(String.valueOf(res.getString("id_role")));


            }

        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n", e.getMessage());
        }
        if (user != null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
            exist = true;
        }
        return exist;
    }


    public User getUserByLogin(String login) {

        ResultSet res = null;
        User user = new User();
        String query = "SELECT * FROM tableName WHERE login='" + login + "'";
        String newQuery = query.replace("tableName", this.tableName);
        try (Connection conn = pool.getConnection();
             PreparedStatement ps = conn.prepareStatement(newQuery)) {

            res = ps.executeQuery();

            while (res.next()) {

                user.setId(String.valueOf(res.getInt("id")));
                user.setName(res.getString("name"));
                user.setLogin(res.getString("login"));
                user.setPassword(res.getString("password"));
                user.setEmail(res.getString("email"));
                user.setDate(res.getString("date"));
                user.setRole( String.valueOf(res.getInt("id_role")));


            }

        } catch (SQLException e) {
            System.out.printf("You have problem: %s ,please try again\n", e.getMessage());
        }

        return user;
    }


}


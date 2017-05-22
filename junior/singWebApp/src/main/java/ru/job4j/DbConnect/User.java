package ru.job4j.DbConnect;

/**
 * Created by Katy on 15.05.2017.
 */
public class User {
    private String id;
    private String name;
    private String login;
    private String email;
    private String date;
    private String password;
    private String role;


    public User() {
    }

    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

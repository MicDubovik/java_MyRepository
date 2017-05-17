package ru.job4j.Servlet3.DbConnect;

/**
 * Structure table.
 */
public class Structure {
    private String id;
    private String name;
    private String login;
    private String email;
    private String date;

    public Structure(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

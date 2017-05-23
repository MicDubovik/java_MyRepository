package ru.job4j.DbConnect;

/**
 * Structure table.
 */
public class Structure {
    /**
     * id.
     */
    private String id;
    /**
     * name.
     */
    private String name;
    /**
     * login.
     */
    private String login;
    /**
     * email.
     */
    private String email;
    /**
     * date.
     */
    private String date;
    /**
     * password.
     */
    private String password;
    /**
     * role.
     */
    private String role;

    /**
     * Constructor.
     */
    public Structure(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    /**
     * Get
     * @return
     */
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Get
     * @return
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Get
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * Set.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Set.
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Get
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Set.
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * Get
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Get
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * Set.
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
}

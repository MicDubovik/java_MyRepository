package ru.job4j.HTTP.DbConnect;



/**
 * User.
 */
public class User {
    /**
     * Id.
     */
    private String id;
    /**
     * Name.
     */
    private String name;
    /**
     * Login.
     */
    private String login;
    /**
     * Email.
     */
    private String email;
    /**
     * Date.
     */
    private String date;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     * @param name
     * @param login
     * @param email
     */
    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;

    }

    /**
     * Get.
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
     * Get.
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set.
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Get.
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Get.
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
     * Get.
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
     * toString.
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

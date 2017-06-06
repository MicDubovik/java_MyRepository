package ru.job4j.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"login", "email"})})
public class User implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String login;
    private String password;
    private String email;

    private String country;
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;


    protected User() {
    }

    public User(String name, String login, String password, String email, String country, String city, Role role_id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.country = country;
        this.city = city;

    }




    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", role_id=" +
                '}';
    }
}

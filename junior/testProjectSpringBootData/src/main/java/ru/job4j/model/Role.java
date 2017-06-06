package ru.job4j.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role implements Serializable{
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String role;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", user=" +
                '}';
    }
}

package com.example.demo.entities;


import javax.persistence.*;


@Entity
@Table(name = "role")
public class Role {



    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role")
    private String role;


    public String getRole() {
        return role;
    }
}

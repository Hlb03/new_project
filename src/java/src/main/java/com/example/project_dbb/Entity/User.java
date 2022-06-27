package com.example.project_dbb.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", unique = true)
    private long userId;

    @Column(name = "nickname")
    private String nickname;
 
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "roleId")
    private Role role;

}

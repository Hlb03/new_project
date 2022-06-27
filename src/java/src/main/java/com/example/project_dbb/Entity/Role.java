package com.example.project_dbb.Entity;

import javax.persistence.*;

public enum Role {

    ADMINISTRATOR(1), MODERATOR(2), USER(3), GUEST(4);

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "roleId", unique = true)
    private long roleId;

    private Role(long id){
        this.roleId = id;
    }
}

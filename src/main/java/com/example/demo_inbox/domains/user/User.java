package com.example.demo_inbox.domains.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userName;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}

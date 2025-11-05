package com.connex.backend.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(nullable=false)
    private String passwordHash;

    @Column(unique=true)
    private String email;

    // role example: ROLE_USER, ROLE_ADMIN
    private String role = "ROLE_USER";

    // getters / setters
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public String getPasswordHash(){return passwordHash;}
    public void setPasswordHash(String passwordHash){this.passwordHash = passwordHash;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public String getRole(){return role;}
    public void setRole(String role){this.role = role;}
}

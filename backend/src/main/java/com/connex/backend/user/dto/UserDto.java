package com.connex.backend.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
    private Long id;

    @NotBlank
    @Size(min=3, max=32)
    private String username;

    private String email;

    // getters/setters
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
}

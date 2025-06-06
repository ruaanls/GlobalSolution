package com.example.globalsolution1.DTO;

import com.example.globalsolution1.Model.UserRole;

public class UsuarioRequest
{
    private String name;
    private String cep;
    private Integer age;
    private UserRole userRole;
    private String username;
    private String password;


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserRole getTipoAcesso() {
        return userRole;
    }

    public void setTipoAcesso(UserRole userRole) {
        this.userRole = userRole;
    }
}

package com.example.globalsolution1.DTO;

import com.example.globalsolution1.Model.UserRole;

public class UsuarioRequest
{
    private String nome;
    private String cidade;
    private Integer idade;
    private UserRole tipo_usuario;
    private String username;
    private String password;


    public UserRole getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(UserRole tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public UserRole getTipoAcesso() {
        return tipo_usuario;
    }

    public void setTipoAcesso(UserRole userRole) {
        this.tipo_usuario = userRole;
    }
}

package com.example.globalsolution1.DTO;

import com.example.globalsolution1.Model.UserRole;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

public class UsuarioRequest
{
    @NotNull(message = "Nome é um campo obrigatório")
    @NotBlank(message = "Campos em branco não são válidos")
    private String nome;
    @NotNull(message = "Cidade é um campo obrigatório")
    @NotBlank(message = "Campos em branco não são válidos")
    private String cidade;
    @NotNull(message = "idade é um campo obrigatório")


    private Integer idade;
    @NotNull(message = "O campo TipoUsuário é obrigatório")

    private UserRole tipo_usuario;

    @NotNull(message = "É obrigatório adicionar um username para criar sua conta")
    @NotBlank(message = "Campos em branco não são válidos")

    private String username;
    @NotNull(message = "É obrigatório adicionar um password(senha) para criar sua conta")
    @NotBlank(message = "Campos em branco não são válidos")

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

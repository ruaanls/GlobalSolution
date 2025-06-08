package com.example.globalsolution1.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginRequest
{
    @NotNull(message = "É obrigatório adicionar um username para criar sua conta")
    @NotBlank(message = "Campos em branco não são válidos")

    private String username;
    @NotNull(message = "É obrigatório adicionar um password(senha) para criar sua conta")
    @NotBlank(message = "Campos em branco não são válidos")

    private String password;


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
}

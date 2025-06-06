package com.example.globalsolution1.Model;

public enum UserRole
{
    USUARIO("Usuário comum"),
    ADM("Administrador -- Acesso total");

    private String descricao;

    UserRole(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }
}

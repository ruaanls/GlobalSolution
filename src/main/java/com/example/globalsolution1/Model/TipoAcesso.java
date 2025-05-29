package com.example.globalsolution1.Model;

public enum TipoAcesso
{
    USUARIO("Usuário comum"),
    ADM("Administrador -- Acesso total");

    private String descricao;

    TipoAcesso(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }
}

package com.example.globalsolution1.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table (name = "usuario")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    private String nome;
    private String cep;
    private Integer idade;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DadosChuva>dadosChuvaList = new ArrayList<>();
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Login login;


    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<DadosChuva> getDadosChuvaList() {
        return dadosChuvaList;
    }

    public void setDadosChuvaList(List<DadosChuva> dadosChuvaList) {
        this.dadosChuvaList = dadosChuvaList;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}

package com.example.globalsolution1.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class Login
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLogin;
    private String username;
    private String senha;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    private Usuario usuario;
}

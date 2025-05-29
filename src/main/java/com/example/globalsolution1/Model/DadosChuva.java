package com.example.globalsolution1.Model;

import jakarta.persistence.*;

@Entity
@Table (name = "dados_chuva")
public class DadosChuva
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_consulta;

    private String cidade;
    private String estado;
    private String data;
    private Double temperaturaMedia;
    private Double totalPrecipitacao;
    private Integer probabilidadeChuva;
    private String conclusao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", nullable = false)
    private Usuario usuario;


    public long getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(long id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(Double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public Double getTotalPrecipitacao() {
        return totalPrecipitacao;
    }

    public void setTotalPrecipitacao(Double totalPrecipitacao) {
        this.totalPrecipitacao = totalPrecipitacao;
    }

    public Integer getProbabilidadeChuva() {
        return probabilidadeChuva;
    }

    public void setProbabilidadeChuva(Integer probabilidadeChuva) {
        this.probabilidadeChuva = probabilidadeChuva;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

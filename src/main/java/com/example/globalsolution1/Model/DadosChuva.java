package com.example.globalsolution1.Model;

import jakarta.persistence.*;

@Entity
@Table (name = "dados_chuva")
public class DadosChuva
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String cidade;
    private String estado;
    private String data;

    private Double temperatura_media;
    @Column(name = "total_precipitacao")
    private Double totalPrecipitacao;
    @Column(name = "probabilidade_de_chuva")
    private Integer probabilidadeChuva;
    private String conclusao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Double getTemperatura_media() {
        return temperatura_media;
    }

    public void setTemperatura_media(Double temperatura_media) {
        this.temperatura_media = temperatura_media;
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

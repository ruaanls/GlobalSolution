package com.example.globalsolution1.DTO;

import java.util.Map;

public class ApiErrorResponse
{
    private String mensagem;
    private Map<String, String> motivos;


    public ApiErrorResponse(String mensagem, Map<String, String> motivos) {
        this.mensagem = mensagem;
        this.motivos = motivos;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Map<String, String> getMotivos() {
        return motivos;
    }

    public void setMotivos(Map<String, String> motivos) {
        this.motivos = motivos;
    }
}

package com.example.globalsolution1.Service;

import com.example.globalsolution1.DTO.DadosChuvaResponse;
import com.example.globalsolution1.Model.DadosChuva;
import org.springframework.stereotype.Service;

@Service
public class DadosChuvaService
{
    private DadosChuva dadosChuva;
    private final UsuarioService usuarioService;

    public DadosChuvaService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public DadosChuvaResponse consultaDadosChuva (String cidade, String dias)
    {
        String key = dadosChuva.getKey();

        //usuarioService.getUsuario()

        // Faz a requisição
        // Recebe o JSON de resposta
        // Monta o Response
        // Salva no banco o respose
        //Devolve o respose depois de salvar no banco
        return null;
    }
}

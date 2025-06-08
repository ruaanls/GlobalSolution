package com.example.globalsolution1.Mapper;

import com.example.globalsolution1.DTO.DadosChuvaResponse;
import com.example.globalsolution1.Model.DadosChuva;
import org.springframework.stereotype.Component;

@Component
public class DadosChuvaMapper
{
    public DadosChuvaResponse dadosChuvaToResponse(DadosChuva dadosChuva)
    {
        DadosChuvaResponse dadosChuvaResponse = new DadosChuvaResponse();
        dadosChuvaResponse.setProbabilidadeChuva(dadosChuva.getProbabilidadeChuva());
        dadosChuvaResponse.setCidade(dadosChuva.getCidade());
        dadosChuvaResponse.setConclusao(dadosChuva.getConclusao());
        dadosChuvaResponse.setData(dadosChuva.getData());
        dadosChuvaResponse.setEstado(dadosChuva.getEstado());
        dadosChuvaResponse.setId_consulta(dadosChuva.getId());
        dadosChuvaResponse.setTemperaturaMedia(dadosChuva.getTemperatura_media());
        dadosChuvaResponse.setTotalPrecipitacao(dadosChuva.getTotalPrecipitacao());
        return dadosChuvaResponse;
    }


}

package com.example.globalsolution1.Controller;

import com.example.globalsolution1.DTO.DadosChuvaRequest;
import com.example.globalsolution1.DTO.DadosChuvaResponse;
import com.example.globalsolution1.Mapper.DadosChuvaMapper;
import com.example.globalsolution1.Service.DadosChuvaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class DadosChuvaController
{
    private final DadosChuvaService dadosChuvaService;

    public DadosChuvaController(DadosChuvaMapper dadosChuvaMapper, DadosChuvaService dadosChuvaService) {
        this.dadosChuvaService = dadosChuvaService;

    }

    @PostMapping
    public ResponseEntity<DadosChuvaResponse> postDadosChuva(@Valid @RequestBody DadosChuvaRequest dadosChuvaRequest)
    {
        dadosChuvaService.consultaDadosChuva(dadosChuvaRequest.getCidade(),dadosChuvaRequest.getDias());

        return null;
    }
}

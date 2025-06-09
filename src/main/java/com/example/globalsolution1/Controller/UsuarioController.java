package com.example.globalsolution1.Controller;


import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.DTO.UsuarioResponse;
import com.example.globalsolution1.Model.Usuario;
import com.example.globalsolution1.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Area;

@RestController
@RequestMapping("/user")
@Tag(name = "Api-Usuário")
public class UsuarioController
{
    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



    @Operation(summary = "Apresenta as informações dos usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário apresentado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping("/{username}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable String username)
    {
        UsuarioResponse usuarioResponse = usuarioService.getUsuario(username);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @Operation(summary = "Apresenta as informações de todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário apresentado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos",
                    content = @Content(schema = @Schema()))
    })

    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> getAllUsuarios(@RequestParam(defaultValue = "0") Integer pageNumber)
    {
        Pageable pageable = PageRequest
                .of(pageNumber, 2, Sort.by("nome").ascending());
        return new ResponseEntity<>(usuarioService.getAllUsuarios(pageable),HttpStatus.OK);
    }


    @Operation(summary = "Atualiza as informações de um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos",
                    content = @Content(schema = @Schema()))
    })

    @PutMapping("/{username}")
    public ResponseEntity<UsuarioResponse> putUsuarioById(@PathVariable String username, @Valid @RequestBody UsuarioRequest usuarioRequest)
    {
        UsuarioResponse usuarioResponse = usuarioService.putUsuario(username, usuarioRequest);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @Operation(summary = "Deleta um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable String username)
    {
        usuarioService.deleteUsuario(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

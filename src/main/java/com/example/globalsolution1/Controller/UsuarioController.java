package com.example.globalsolution1.Controller;


import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.DTO.UsuarioResponse;
import com.example.globalsolution1.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UsuarioController
{
    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



    @GetMapping("/{username}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable String username)
    {
        UsuarioResponse usuarioResponse = usuarioService.getUsuario(username);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UsuarioResponse> putUsuarioById(@PathVariable String username, @Valid @RequestBody UsuarioRequest usuarioRequest)
    {
        UsuarioResponse usuarioResponse = usuarioService.putUsuario(username, usuarioRequest);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable String username)
    {
        usuarioService.deleteUsuario(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

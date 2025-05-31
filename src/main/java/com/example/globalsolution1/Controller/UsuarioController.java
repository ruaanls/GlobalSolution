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

@RestController
@RequestMapping("/usuario")
public class UsuarioController
{
    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse>createUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest)
    {
        UsuarioResponse usuarioResponse = usuarioService.createUsuario(usuarioRequest);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable Long id)
    {
        UsuarioResponse usuarioResponse = usuarioService.getUsuario(id);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> putUsuarioById(@PathVariable Long id, @Valid @RequestBody UsuarioRequest usuarioRequest)
    {
        UsuarioResponse usuarioResponse = usuarioService.putUsuario(id, usuarioRequest);
        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id)
    {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

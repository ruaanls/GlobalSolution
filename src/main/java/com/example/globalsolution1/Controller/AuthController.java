package com.example.globalsolution1.Controller;



import com.example.globalsolution1.DTO.LoginRequest;
import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.Mapper.UsuarioMapper;
import com.example.globalsolution1.Model.Usuario;
import com.example.globalsolution1.Repository.UsuarioRepository;
import com.example.globalsolution1.Service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticateManager;

    private final UsuarioMapper usuarioMapper = new UsuarioMapper();

    @PostMapping("/registrar")
    public ResponseEntity<Void> createUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest)
    {
        if(usuarioRepository.findByUsername(usuarioRequest.getUsername()) != null)
        {
            return ResponseEntity.badRequest().build();
        }
        String senhaCriptografada = new BCryptPasswordEncoder()
                .encode(usuarioRequest.getPassword());
        Usuario novoUsuario = usuarioMapper.requestToUsuario(usuarioRequest);
        novoUsuario.setPassword(senhaCriptografada);
        usuarioRepository.save(novoUsuario);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest)
    {
        var userPassword = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword());
        var autenticacao = this.authenticateManager.authenticate(userPassword);
        var token = tokenService.generateToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(token);
    }



}

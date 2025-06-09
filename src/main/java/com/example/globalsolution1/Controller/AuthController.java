package com.example.globalsolution1.Controller;



import com.example.globalsolution1.DTO.LoginRequest;
import com.example.globalsolution1.DTO.LoginResponse;
import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.Mapper.AuthMapper;
import com.example.globalsolution1.Mapper.UsuarioMapper;
import com.example.globalsolution1.Model.Usuario;
import com.example.globalsolution1.Repository.UsuarioRepository;
import com.example.globalsolution1.Service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.awt.geom.Area;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Tag(name = "Api-Autenticação")
public class AuthController
{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticateManager;
    private String userRole;

    private final UsuarioMapper usuarioMapper = new UsuarioMapper();
    private final AuthMapper authMapper = new AuthMapper();

    @Operation(summary = "Cria um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Area.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping("/registrar")
    public ResponseEntity<?> createUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest)
    {
        if(usuarioRepository.findByUsername(usuarioRequest.getUsername()) != null)
        {
            Map<String, String> erro = Map.of("erro", "Username já existente, por favor tente novamente um diferente");
            return ResponseEntity.badRequest().body(erro);
        }
        String senhaCriptografada = new BCryptPasswordEncoder()
                .encode(usuarioRequest.getPassword());
        Usuario novoUsuario = usuarioMapper.requestToUsuario(usuarioRequest);
        novoUsuario.setPassword(senhaCriptografada);
        usuarioRepository.save(novoUsuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Realiza um login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Area.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos",
                    content = @Content(schema = @Schema()))
    })

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
    {
        var userPassword = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword());
        var autenticacao = this.authenticateManager.authenticate(userPassword);
        var token = tokenService.generateToken((Usuario) autenticacao.getPrincipal());
        Optional<? extends GrantedAuthority> userRole = autenticacao.getAuthorities().stream().findFirst();
        if(userRole.isPresent())
        {
            this.userRole = String.valueOf(userRole);
            this.userRole= this.userRole.replace("Optional[", "")
                    .replace("]", "")
                    .replace("_", " ");
        }
        LoginResponse loginResponse = authMapper.makeLoginResponse(token,loginRequest.getUsername(),this.userRole);
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);

    }



}

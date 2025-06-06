package com.example.globalsolution1.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.globalsolution1.Model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService
{
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Usuario usuario)
    {
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("apisecurity")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(genExpirationTime())
                    .sign(algorithm);

        }
         catch (JWTCreationException e) {
            throw new RuntimeException("Erro na geração do token JWT: ", e);
        }

    }

    private Instant genExpirationTime()
    {
        return LocalDateTime
                .now()
                .plusMinutes(15)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token )
    {
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("apisecurity")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception)
        {
            return null;
        }
    }

}

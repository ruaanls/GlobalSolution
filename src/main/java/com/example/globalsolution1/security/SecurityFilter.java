package com.example.globalsolution1.security;

import com.example.globalsolution1.Service.AuthenticationService;
import com.example.globalsolution1.Service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter
{
    private final TokenService tokenService;
    private final AuthenticationService authenticationService;

    public SecurityFilter(TokenService tokenService, AuthenticationService authenticationService) {
        this.tokenService = tokenService;
        this.authenticationService = authenticationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.replaceBearer(request);
        if (token != null) {
            var username = tokenService.validateToken(token);
            UserDetails userDetails = this.authenticationService.loadUserByUsername(username);
            var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String replaceBearer(HttpServletRequest request)
    {
        var header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer "))
        {
            return null;
        }
        return header.replace("Bearer ", "");
    }
}

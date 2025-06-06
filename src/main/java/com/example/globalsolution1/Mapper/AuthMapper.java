package com.example.globalsolution1.Mapper;

import com.example.globalsolution1.DTO.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper
{
    public LoginResponse makeLoginResponse(String jwtToken, String username, String userRole)
    {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken(jwtToken);
        loginResponse.setUsername(username);
        loginResponse.setUserRole(userRole);
        return loginResponse;
    }
}

package com.example.globalsolution1.Mapper;

import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.DTO.UsuarioResponse;
import com.example.globalsolution1.Model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper
{
    public Usuario requestToUsuario(UsuarioRequest usuarioRequest)
    {
        if(usuarioRequest == null)
        {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setCep(usuarioRequest.getCep());
        usuario.setIdade(usuarioRequest.getAge());
        usuario.setNome(usuarioRequest.getName());
        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setUserRole(usuarioRequest.getUserRole());
        return usuario;
    }

    public UsuarioResponse usuarioToResponse(Usuario usuario)
    {
        if(usuario == null)
        {
            return null;
        }
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setIdUsuario(usuario.getIdUsuario());
        usuarioResponse.setNome(usuario.getNome());
        usuarioResponse.setCep(usuario.getCep());
        usuarioResponse.setIdade(usuario.getIdade());
        return usuarioResponse;
    }

}

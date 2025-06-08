package com.example.globalsolution1.Mapper;

import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.DTO.UsuarioResponse;
import com.example.globalsolution1.Model.UserRole;
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
        usuario.setCidade(usuarioRequest.getCidade());
        usuario.setIdade(usuarioRequest.getIdade());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setUsername(usuarioRequest.getUsername());
        if(usuarioRequest.getTipo_usuario() == null)
        {
            usuario.setUserRole(UserRole.USUARIO);
        }
        else
        {
            usuario.setUserRole(usuarioRequest.getTipo_usuario());
        }


        return usuario;
    }

    public UsuarioResponse usuarioToResponse(Usuario usuario)
    {
        if(usuario == null)
        {
            return null;
        }
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setIdUsuario(usuario.getId());
        usuarioResponse.setNome(usuario.getNome());
        usuarioResponse.setCep(usuario.getCidade());
        usuarioResponse.setIdade(usuario.getIdade());
        usuarioResponse.setUsername(usuario.getUsername());

        return usuarioResponse;
    }

}

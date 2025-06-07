package com.example.globalsolution1.Service;

import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.DTO.UsuarioResponse;
import com.example.globalsolution1.Mapper.UsuarioMapper;
import com.example.globalsolution1.Model.Usuario;
import com.example.globalsolution1.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService
{
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }





    public UsuarioResponse getUsuario(String username)
    {
        return usuarioMapper.usuarioToResponse(usuarioRepository.findUsuarioByUsername(username));
    }

    @Transactional
    public UsuarioResponse putUsuario(String username, UsuarioRequest usuarioRequest)
    {
        Usuario usuario = usuarioRepository.findUsuarioByUsername(username);
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCidade(usuarioRequest.getCidade());
        usuario.setIdade(usuarioRequest.getIdade());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setUserRole(usuarioRequest.getTipo_usuario());
        return usuarioMapper.usuarioToResponse(usuarioRepository.save(usuario));
    }

    public void deleteUsuario(String username)
    {
        usuarioRepository.deleteByUsername(username);
    }
}

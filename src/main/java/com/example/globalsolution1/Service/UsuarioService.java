package com.example.globalsolution1.Service;

import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.DTO.UsuarioResponse;
import com.example.globalsolution1.Mapper.UsuarioMapper;
import com.example.globalsolution1.Model.Usuario;
import com.example.globalsolution1.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
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



    public UsuarioResponse createUsuario(UsuarioRequest usuarioRequest)
    {
        return usuarioMapper.usuarioToResponse(usuarioRepository.save(usuarioMapper.requestToUsuario(usuarioRequest)));
    }

    public UsuarioResponse getUsuario(UUID idUsuario)
    {
        return usuarioMapper.usuarioToResponse(usuarioRepository.findById(idUsuario).orElseThrow(() ->new EntityNotFoundException("Usuário não encontrado")));
    }

    public UsuarioResponse putUsuario(UUID idUsuario, UsuarioRequest usuarioRequest)
    {
        Usuario ususario = usuarioRepository.findById(idUsuario).orElseThrow(()-> new EntityNotFoundException ("Usuário não encontrado" ));
        ususario.setNome(usuarioRequest.getName());
        ususario.setCep(usuarioRequest.getCep());
        ususario.setIdade(usuarioRequest.getAge());
        return usuarioMapper.usuarioToResponse(usuarioRepository.save(ususario));
    }

    public void deleteUsuario(UUID idUsuario)
    {
        usuarioRepository.deleteById(idUsuario);
    }
}

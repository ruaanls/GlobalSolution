package com.example.globalsolution1.Service;

import com.example.globalsolution1.DTO.UsuarioRequest;
import com.example.globalsolution1.DTO.UsuarioResponse;
import com.example.globalsolution1.Mapper.UsuarioMapper;
import com.example.globalsolution1.Model.Usuario;
import com.example.globalsolution1.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

        Usuario usuarioExistente = usuarioRepository.findUsuarioByUsername(username);
        if (usuarioExistente == null) {

            throw new EntityNotFoundException("Usuário não encontrado: " + username);
        }


        usuarioExistente.setNome(usuarioRequest.getNome());
        usuarioExistente.setCidade(usuarioRequest.getCidade());
        usuarioExistente.setIdade(usuarioRequest.getIdade());
        usuarioExistente.setUsername(usuarioRequest.getUsername());
        String senhaCriptografada = new BCryptPasswordEncoder()
                .encode(usuarioRequest.getPassword());
        usuarioExistente.setPassword(senhaCriptografada);
        usuarioExistente.setUserRole(usuarioRequest.getTipo_usuario());


        Usuario usuarioAtualizado = usuarioRepository.save(usuarioExistente);

        return usuarioMapper.usuarioToResponse(usuarioAtualizado);
    }

    public void deleteUsuario(String username)
    {
        usuarioRepository.deleteByUsername(username);
    }
}

package com.example.globalsolution1.Repository;

import com.example.globalsolution1.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    UserDetails findByUsername(String username);
    Usuario findUsuarioByUsername(String username);
    void deleteByUsername(String username);

}

package com.example.globalsolution1.Repository;

import com.example.globalsolution1.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

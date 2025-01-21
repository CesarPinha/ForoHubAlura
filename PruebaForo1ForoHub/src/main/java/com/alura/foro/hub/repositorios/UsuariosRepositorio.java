package com.alura.foro.hub.repositorios;

import com.alura.foro.hub.dominio.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String username);
}

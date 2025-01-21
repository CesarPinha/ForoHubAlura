package com.alura.foro.hub.repositorios;

import com.alura.foro.hub.dominio.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTitulo(String Titulo);
}

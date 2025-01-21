package com.alura.foro.hub.dominio.validaciones;

import com.alura.foro.hub.dominio.topico.DatosGeneralTopico;
import com.alura.foro.hub.infra.manejoErrores.ValidacionException;
import com.alura.foro.hub.repositorios.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUnicoNombreDelTopico implements ValidadorNombre{

    @Autowired
    TopicoRepository repository;

    @Override
    public void validar(DatosGeneralTopico datosGeneralTopico) {
        if (repository.findByTitulo(datosGeneralTopico.titulo()).isPresent()){
            throw new ValidacionException("El tópico ya existe");
        }
    }

}

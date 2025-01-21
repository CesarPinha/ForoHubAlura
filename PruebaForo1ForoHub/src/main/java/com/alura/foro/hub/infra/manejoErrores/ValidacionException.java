package com.alura.foro.hub.infra.manejoErrores;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}

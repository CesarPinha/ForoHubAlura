package com.alura.foro.hub.controladores;

import com.alura.foro.hub.dominio.usuario.DatosAutenticacionUsuario;
import com.alura.foro.hub.dominio.usuario.Usuario;
import com.alura.foro.hub.infra.seguridad.Token;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    private final AuthenticationManager authenticationManager;
    private final Token token;

    public AutenticacionController(AuthenticationManager authenticationManager, Token token) {
        this.authenticationManager = authenticationManager;
        this.token = token;
    }

    @PostMapping
    public ResponseEntity<String> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave()
        );

        Authentication usuarioAutenticado = authenticationManager.authenticate(authToken);
        String jwtToken = token.obtenerToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(jwtToken);
    }
}

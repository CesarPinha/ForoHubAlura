package com.alura.foro.hub.infra.seguridad;

import com.alura.foro.hub.dominio.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class Token {

    private static final Logger logger = LoggerFactory.getLogger(Token.class);
    private final String apiSecret;

    public Token(@Value("${api.security.secret}") String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String obtenerToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("usuarios")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            logger.error("Error al crear el token JWT", exception);
            throw new RuntimeException("Error al crear el token JWT", exception);
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer("usuarios")
                    .build()
                    .verify(token);

            String subject = decodedJWT.getSubject();
            if (subject == null) {
                logger.error("El token no contiene un sujeto (subject) válido.");
                throw new RuntimeException("Token inválido: sujeto nulo");
            }
            return subject;
        } catch (JWTVerificationException exception) {
            logger.error("Error al verificar el token JWT: {}", exception.getMessage());
            throw new RuntimeException("Verificación del token fallida", exception);
        }
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.ofHours(-5));
    }
}

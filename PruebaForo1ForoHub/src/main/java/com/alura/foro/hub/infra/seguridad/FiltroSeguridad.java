package com.alura.foro.hub.infra.seguridad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class FiltroSeguridad extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(FiltroSeguridad.class);
    private final String apiSecret;

    public FiltroSeguridad(@Value("${api.security.secret}") String apiSecret) {
        this.apiSecret = apiSecret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        logger.info("Filtro de seguridad ejecutado para: {}", request.getServletPath());

        try {
            String header = request.getHeader("Authorization");
            if (header != null && header.startsWith("Bearer ")) {
                String token = header.replace("Bearer ", "");
                Algorithm algorithm = Algorithm.HMAC256(apiSecret);
                var verifier = JWT.require(algorithm).withIssuer("usuarios").build();
                DecodedJWT decodedToken = verifier.verify(token);

                logger.info("Token válido para: {}", decodedToken.getSubject());
                logger.debug("Claims del token: {}", decodedToken.getClaims());

                String username = decodedToken.getSubject();
                if (username != null) {
                    var authentication = new UsernamePasswordAuthenticationToken(
                            username, null, Collections.emptyList()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (JWTVerificationException e) {
            logger.error("Error de validación del token: {}", e.getMessage());
            // Limpiar contexto de seguridad en caso de error
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}

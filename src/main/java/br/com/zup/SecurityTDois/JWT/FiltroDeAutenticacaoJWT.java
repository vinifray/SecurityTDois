package br.com.zup.SecurityTDois.JWT;

import br.com.zup.SecurityTDois.JWT.dtos.LoginDTO;
import br.com.zup.SecurityTDois.exceptions.AccessoNegadoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FiltroDeAutenticacaoJWT extends UsernamePasswordAuthenticationFilter {
    private JWTComponente jwtComponente;
    private AuthenticationManager authenticationManager;

    public FiltroDeAutenticacaoJWT(AuthenticationManager authenticationManager, JWTComponente jwtComponente) {
        this.jwtComponente = jwtComponente;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            LoginDTO login = objectMapper.readValue(request.getInputStream(), LoginDTO.class);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    login.getEmail(), login.getSenha(), new ArrayList<>()
            );

            Authentication auth = authenticationManager.authenticate(authToken);
            return auth;
        }catch (IOException exception){
            throw new AccessoNegadoException();
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UsuarioLogin usuarioLogin = (UsuarioLogin) authResult.getPrincipal();
        String username = usuarioLogin.getUsername();
        int idUsuario = usuarioLogin.getId();

        String token = jwtComponente.gerarToken(username, idUsuario);

        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Authorization", "Token "+token);


    }
}

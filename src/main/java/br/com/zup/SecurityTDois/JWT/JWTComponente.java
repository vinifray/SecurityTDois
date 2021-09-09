package br.com.zup.SecurityTDois.JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTComponente {
    private String chave = "xablau";
    private Long milissegundos = 60000l;

    public String gerarToken(String username, int idUsuario){
        Date vecimento = new Date(System.currentTimeMillis() + milissegundos);

        String token = Jwts.builder().setSubject(username)
                .claim("idUsuario", idUsuario).setExpiration(vecimento)
                .signWith(SignatureAlgorithm.ES512, chave.getBytes()).compact();

        return token;
    }
}

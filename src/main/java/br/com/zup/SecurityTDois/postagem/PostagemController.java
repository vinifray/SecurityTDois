package br.com.zup.SecurityTDois.postagem;

import br.com.zup.SecurityTDois.JWT.JWTComponente;
import br.com.zup.SecurityTDois.JWT.UsuarioLogin;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RequestMapping("/postagens")
@RestController
public class PostagemController {
    @Autowired
    private PostagemService postagemService;
    @Autowired
    private JWTComponente jwtComponente;

    /*
    Metodo com ID e trabalhando com Token e seus Claims
    @PostMapping()
    public Postagem cadastrarPostagem(@RequestBody Postagem postagem, HttpServletRequest request){
        String toke = request.getHeader("Authorization");
        Claims claims = jwtComponente.getClaims(toke.substring(6));
        return postagemService.cadastrarPostagem((int) claims.get("idUsuario"), postagem);
    }

     */

    // metodo utilizando o email com authentication
    @PostMapping()
    public Postagem cadastrarPostagem(@RequestBody Postagem postagem, Authentication authentication){
        String email = authentication.getName();
        return postagemService.cadastrarPostagem(email, postagem);
    }

}

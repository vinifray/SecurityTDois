package br.com.zup.SecurityTDois.postagem;

import br.com.zup.SecurityTDois.JWT.UsuarioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/postagens")
@RestController
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    @PostMapping("/{idUsaurio}")
    public Postagem cadastrarPostagem(@RequestBody Postagem postagem, @PathVariable int idUsuario,
                                      @AuthenticationPrincipal UsuarioLogin usuarioLogin){
        return postagemService.cadastrarPostagem(usuarioLogin.getId(), postagem);
    }
}

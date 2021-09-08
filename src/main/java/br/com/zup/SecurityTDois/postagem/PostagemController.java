package br.com.zup.SecurityTDois.postagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/postagens")
@RestController
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    @PostMapping("/{idUsaurio}")
    public Postagem cadastrarPostagem(@RequestBody Postagem postagem, @PathVariable int idUsuario){
        return postagemService.cadastrarPostagem(idUsuario, postagem);
    }
}

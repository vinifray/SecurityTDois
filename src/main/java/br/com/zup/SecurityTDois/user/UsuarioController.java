package br.com.zup.SecurityTDois.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }
}

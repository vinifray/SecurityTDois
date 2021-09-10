package br.com.zup.SecurityTDois.perfil;

import br.com.zup.SecurityTDois.components.Conversor;
import br.com.zup.SecurityTDois.perfil.dtos.PostagemDTO;
import br.com.zup.SecurityTDois.perfil.dtos.UsuarioDTO;
import br.com.zup.SecurityTDois.postagem.Postagem;
import br.com.zup.SecurityTDois.postagem.PostagemRepository;
import br.com.zup.SecurityTDois.postagem.PostagemService;
import br.com.zup.SecurityTDois.user.Usuario;
import br.com.zup.SecurityTDois.user.UsuarioRepository;
import br.com.zup.SecurityTDois.user.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PostagemRepository postagemRepository;
    @Autowired
    private ObjectMapper conversor;


    @GetMapping
    public UsuarioDTO exibirPerfil(Authentication authentication){
        Usuario usuario = usuarioRepository.findByEmail(authentication.getName()).get();
        List<Postagem> postagens = postagemRepository.findAllByUsuarioEmail(authentication.getName());

        List<PostagemDTO> postagemDTOS = postagens.stream()
                .map(postagem -> conversor.convertValue(postagem, PostagemDTO.class) ).collect(Collectors.toList());
        UsuarioDTO usuarioDTO = conversor.convertValue(usuario, UsuarioDTO.class);
        usuarioDTO.setPostagens(postagemDTOS);
        return usuarioDTO;
    }

}

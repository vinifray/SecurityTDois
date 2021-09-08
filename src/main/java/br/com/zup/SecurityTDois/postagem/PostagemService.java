package br.com.zup.SecurityTDois.postagem;

import br.com.zup.SecurityTDois.user.Usuario;
import br.com.zup.SecurityTDois.user.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;
    @Autowired
    private UsuarioService usuarioService;

    public Postagem cadastrarPostagem(int idUsuario, Postagem postagem){
        Usuario usuario = usuarioService.buscarUsuarioPeloId(idUsuario);

        postagem.setUsuario(usuario);
        postagem.setData(LocalDate.now());

        return postagemRepository.save(postagem);
    }

    public List<Postagem> pesquisarPostagemPeloUsuarioId(int idUsuario){
        return postagemRepository.findAllByUsuarioId(idUsuario);
    }
}

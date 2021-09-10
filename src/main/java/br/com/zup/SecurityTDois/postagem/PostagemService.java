package br.com.zup.SecurityTDois.postagem;

import br.com.zup.SecurityTDois.user.Usuario;
import br.com.zup.SecurityTDois.user.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Postagem cadastrarPostagem(String email, Postagem postagem){
        Usuario usuario = usuarioService.buscarUsuarioPeloEmail(email);

        postagem.setUsuario(usuario);
        postagem.setData(LocalDate.now());

        return postagemRepository.save(postagem);
    }

    public List<Postagem> pesquisarPostagemPeloUsuarioId(int idUsuario){
        return postagemRepository.findAllByUsuarioId(idUsuario);
    }

    public void apagarMensagem(int idMensagem, String emailAuthor){
        if(!mensagemDoAutor(idMensagem, emailAuthor)){
            throw new RuntimeException("O Author pode apagar apenas as proprias mensagens");
        }
        postagemRepository.deleteById(idMensagem);
    }

    public boolean mensagemDoAutor(int idMensagem, String emailAuthor){
        Optional<Postagem> postagemOptional = postagemRepository.findById(idMensagem);

        postagemOptional.orElseThrow(() -> new RuntimeException("Postagem não encontrada"));

        if(!postagemOptional.get().getUsuario().getEmail().equals(emailAuthor)){
            return false;
        }
        return true;
    }
}

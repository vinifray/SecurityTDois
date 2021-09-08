package br.com.zup.SecurityTDois.postagem;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostagemRepository extends CrudRepository<Postagem, Integer> {

    List<Postagem> findAllByUsuarioId(int usuarioId);
}

package br.com.zup.SecurityTDois.perfil.dtos;

import java.util.List;

public class UsuarioDTO {

    private String nome;
    private String email;
    private List<PostagemDTO> postagens;

    public UsuarioDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PostagemDTO> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<PostagemDTO> postagens) {
        this.postagens = postagens;
    }
}

package br.com.zup.SecurityTDois.perfil.dtos;

import java.time.LocalDate;

public class PostagemDTO {
    private int id;
    private String mensagem;
    private LocalDate data;

    public PostagemDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

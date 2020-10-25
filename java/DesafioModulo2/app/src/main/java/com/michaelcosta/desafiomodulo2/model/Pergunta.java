package com.michaelcosta.desafiomodulo2.model;

public class Pergunta {
    private String descricao;
    private Boolean verdadeiro;
    private boolean respondeu;

    public Pergunta(String descricao, Boolean verdadeiro) {
        this.descricao = descricao;
        this.verdadeiro = verdadeiro;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean isVerdadeiro() {
        return verdadeiro;
    }

    public void setVerdadeiro(Boolean verdadeiro) {
        this.verdadeiro = verdadeiro;
    }

    public boolean isRespondeu() {
        return respondeu;
    }

    public void setRespondeu(boolean respondeu) {
        this.respondeu = respondeu;
    }
}

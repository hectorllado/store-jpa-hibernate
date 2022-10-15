package br.com.hector.store.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
    private String nome;
    private String cpf;

    public DadosPessoais(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public DadosPessoais() {
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }
}

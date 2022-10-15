package br.com.hector.store.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    public Cliente(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosPessoais dadosPessoais;

    public Cliente(String nome, String cpf) {
        this.dadosPessoais = new DadosPessoais(nome, cpf);
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public String getNome() {
        return this.dadosPessoais.getNome();
    }

    public String getCpf() {
        return this.dadosPessoais.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
package br.com.hector.store.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    public Categoria() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

}

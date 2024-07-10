package com.devsuperior.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <h1> DEVSUPERIOR - Java Spring Professional - Capítulo: Modelo de domínio e ORM</h1>
 * DESAFIO: Modelo de domínio e ORM
 * <p>
 * <b>Note:</b> Desenvolvido na linguagem Java.
 *
 * @author  Marcos Ferreira Shirafuchi
 * @version 1.0
 * @since   09/07/2024
 */

//Mapear a classe Categoria
@Entity
//Vai customizar o nome da tabela do banco de dados
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    //Uma categoria para muitas atividades
    //Neste caso tem que colocar uma lista
    //MappedBy = "categoria" é o nome do atributo da classe Atividade
    //Quando é relacionamento OneToMany, colocar list
    @OneToMany(mappedBy = "categoria")
    private List<Atividade> atividades = new ArrayList<>();

    public Categoria(){

    }

    public Categoria(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

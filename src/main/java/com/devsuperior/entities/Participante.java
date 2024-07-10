package com.devsuperior.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

//Mapear a classe Bloco
@Entity
//Vai customizar o nome da tabela do banco de dados
@Table(name = "tb_participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    //Nome do atributo mapeado na classe Atividade
    @ManyToMany
    //Vai juntar a tabela atividades
    @JoinTable(name = "tb_participante_atividade",
            //Vai colocar o id da tabela Product na tabela product_category
            joinColumns = @JoinColumn(name = "participante_id"),
            //Vai colocar o id da tabela Category na tabela product_category
            inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    //Quando não tem repetição, usar Set e não list
    private Set<Atividade> atividades = new HashSet<>();

    public Participante(){

    }

    public Participante(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participante that = (Participante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

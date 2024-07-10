package com.devsuperior.entities;

import jakarta.persistence.*;

import java.util.*;
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

//Mapear a classe Atividade
@Entity
//Vai customizar o nome da tabela do banco de dados
@Table(name = "tb_atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;

    //Vai adicionar o campo categoria_id na tabela tb_atividade que é chave estrangeira
    //Muitas atividades para uma categoria
    @ManyToOne
    //Definindo a classe estrangeira da tabela tb_categoria da classer Categoria
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    //Uma atividade para muitos blocos
    //Neste caso tem que colocar uma lista
    //MappedBy = "atividade" é o nome do atributo da classe Bloco
    @OneToMany(mappedBy = "atividade")
    List<Bloco> blocos = new ArrayList<>();

    //Nome do atributo mapeado na classe Participante
    @ManyToMany(mappedBy = "atividades")
    //Quando não tem repetição, usar Set e não list
    Set<Participante> participantes = new HashSet<>();

    public Atividade(){

    }

    public Atividade(Integer id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;
        return Objects.equals(id, atividade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

package com.devsuperior.entities;

import jakarta.persistence.*;

import java.time.Instant;
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

//Mapear a classe Bloco
@Entity
//Vai customizar o nome da tabela do banco de dados
@Table(name = "tb_bloco")
public class Bloco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant inicio;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant fim;

    //Vai adicionar o campo atividade_id na tabela tb_bloco que é chave estrangeira
    //Muitos blocos para uma atividade
    @ManyToOne
    //Definindo a classe estrangeira da tabela tb_atividade da classer Atividade
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    public Bloco(){

    }

    public Bloco(Integer id, Instant inicio, Instant fim, Atividade atividade) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.atividade = atividade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getInicio() {
        return inicio;
    }

    public void setInicio(Instant inicio) {
        this.inicio = inicio;
    }

    public Instant getFim() {
        return fim;
    }

    public void setFim(Instant fim) {
        this.fim = fim;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bloco bloco = (Bloco) o;
        return Objects.equals(id, bloco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

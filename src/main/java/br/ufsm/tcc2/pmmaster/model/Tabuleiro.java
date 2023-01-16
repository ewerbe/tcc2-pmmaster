package br.ufsm.tcc2.pmmaster.model;

import javax.persistence.*;

@Entity
@Table
public class Tabuleiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TABULEIRO", unique = true)
    private Long id;

    @Column(name = "ATIVO")
    private Boolean ativo;

    public Tabuleiro() {
    }

    public Tabuleiro(Long id, Boolean ativo) {
        this.id = id;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

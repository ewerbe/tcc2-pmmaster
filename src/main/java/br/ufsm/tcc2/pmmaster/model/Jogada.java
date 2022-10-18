package br.ufsm.tcc2.pmmaster.model;

import javax.persistence.*;

@Entity
@Table
public class Jogada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_JOGADA", unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name="ID_TABULEIRO")
    private Tabuleiro idTabuleiro;

    @OneToOne
    @JoinColumn(name="ID_CARTA")
    private Carta idCarta;

    @Column(name = "ATIVA")
    private Boolean ativa;

    public Jogada() {
    }

    public Jogada(Tabuleiro idTabuleiro, Carta idCarta, Boolean ativa) {
        this.idTabuleiro = idTabuleiro;
        this.idCarta = idCarta;
        this.ativa = ativa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tabuleiro getIdTabuleiro() {
        return idTabuleiro;
    }

    public void setIdTabuleiro(Tabuleiro idTabuleiro) {
        this.idTabuleiro = idTabuleiro;
    }

    public Carta getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Carta idCarta) {
        this.idCarta = idCarta;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }
}

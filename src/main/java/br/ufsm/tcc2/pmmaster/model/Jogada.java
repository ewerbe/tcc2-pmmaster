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
    private Tabuleiro tabuleiro;

    @OneToOne
    @JoinColumn(name="ID_CARTA")
    private Carta idCarta;

    @Column(name = "ATIVA")
    private Boolean ativa;

    @Column(name = "ANTIGA")
    private Boolean antiga;

    public Jogada() {
    }

    public Jogada(Tabuleiro tabuleiro, Carta idCarta, Boolean ativa, Boolean antiga) {
        this.tabuleiro = tabuleiro;
        this.idCarta = idCarta;
        this.ativa = ativa;
        this.antiga = antiga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
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

    public Boolean getAntiga() {
        return antiga;
    }

    public void setAntiga(Boolean antiga) {
        this.antiga = antiga;
    }
}

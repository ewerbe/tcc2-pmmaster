package br.ufsm.tcc2.pmmaster.model;

import javax.persistence.*;

@Entity
@Table
public class Tabuleiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TABULEIRO", unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario idUsuario;

    public Tabuleiro() {
    }

    public Tabuleiro(Usuario idUsuario, byte[] qrCode, byte[] arquivoTabuleiro) {
        this.idUsuario = idUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}

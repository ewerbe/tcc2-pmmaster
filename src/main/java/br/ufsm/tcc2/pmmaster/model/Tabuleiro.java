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

    @Column(name = "QR_CODE")
    private byte[] qrCode;

    @Column(name = "ARQUIVO_TABULEIRO")
    private byte[] arquivoTabuleiro;

    public Tabuleiro() {
    }

    public Tabuleiro(Usuario idUsuario, byte[] qrCode, byte[] arquivoTabuleiro) {
        this.idUsuario = idUsuario;
        this.qrCode = qrCode;
        this.arquivoTabuleiro = arquivoTabuleiro;
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

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }

    public byte[] getArquivoTabuleiro() {
        return arquivoTabuleiro;
    }

    public void setArquivoTabuleiro(byte[] arquivoTabuleiro) {
        this.arquivoTabuleiro = arquivoTabuleiro;
    }
}

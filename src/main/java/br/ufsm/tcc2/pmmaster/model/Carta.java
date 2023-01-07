package br.ufsm.tcc2.pmmaster.model;

import javax.persistence.*;

@Entity
@Table
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CARTA", unique = true, length = 400)
    private Long id;

    @OneToOne
    @JoinColumn(name="ID_AREA_CONHEC")
    private AreaConhecimento areaConhecimento;

    @Column(name = "PERGUNTA")
    private String pergunta;

    @Column(name = "ALTERN_A")
    private String altern_A;

    @Column(name = "ALTERN_B")
    private String altern_B;

    @Column(name = "ALTERN_C")
    private String altern_C;

    @Column(name = "ALTERN_D")
    private String altern_D;

    @Column(name = "ALTERN_CORRETA")
    private String altern_correta;

    //atributo para "jogar a carta para o fundo do baralho" para não ser repetida na mesma partida;
    @Column(name = "ATIVA")
    private Boolean ativa;

    public Carta() {
    }

    public Carta(AreaConhecimento areaConhecimento, String pergunta, String altern_A, String altern_B,
                 String altern_C, String altern_D, String altern_correta, Boolean ativa) {
        this.areaConhecimento = areaConhecimento;
        this.pergunta = pergunta;
        this.altern_A = altern_A;
        this.altern_B = altern_B;
        this.altern_C = altern_C;
        this.altern_D = altern_D;
        this.altern_correta = altern_correta;
        this.ativa = ativa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AreaConhecimento getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getAltern_A() {
        return altern_A;
    }

    public void setAltern_A(String altern_A) {
        this.altern_A = altern_A;
    }

    public String getAltern_B() {
        return altern_B;
    }

    public void setAltern_B(String altern_B) {
        this.altern_B = altern_B;
    }

    public String getAltern_C() {
        return altern_C;
    }

    public void setAltern_C(String altern_C) {
        this.altern_C = altern_C;
    }

    public String getAltern_D() {
        return altern_D;
    }

    public void setAltern_D(String altern_D) {
        this.altern_D = altern_D;
    }

    public String getAltern_correta() {
        return altern_correta;
    }

    public void setAltern_correta(String altern_correta) {
        this.altern_correta = altern_correta;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }
}

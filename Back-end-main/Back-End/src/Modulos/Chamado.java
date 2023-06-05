package Modulos;

import java.time.LocalDate;

public class Chamado {
    private String nomeChamado, descricao;
    private LocalDate inicioChamado;
    private int urgencia, responsavelChamado, responsavelSolicitante;
    private Setor setor;
    private ChamadoStatus chamadoStatus;
    public Object getSetor;



    public Chamado(String nomeChamado, String descricao, int responsavelChamado, int urgencia, LocalDate inicioChamado, int responsavelSolicitante, ChamadoStatus chamadoStatus, Setor setor) {
        this.nomeChamado = nomeChamado;
        this.descricao = descricao;
        this.responsavelChamado = responsavelChamado;
        this.responsavelSolicitante = responsavelSolicitante;
        this.inicioChamado = inicioChamado;
        this.urgencia = urgencia;
        this.chamadoStatus = chamadoStatus;
        this.setor = setor;
    }

    public Chamado(){

    }

    public Setor getSetor(){
        return setor;
    }

    public String getNomeChamado() {
        return this.nomeChamado;
    }

    public void setNomeChamado(String nomeChamado) {
        this.nomeChamado = nomeChamado;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getResponsavelChamado() {
        return this.responsavelChamado;
    }

    public void setResponsavelChamado(int responsavelChamado) {
        this.responsavelChamado = responsavelChamado;
    }

    public int getResponsavelSolicitante() {
        return this.responsavelSolicitante;
    }

    public void setResponsavelSolicitante(int responsavelSolicitante) {
        this.responsavelSolicitante = responsavelSolicitante;
    }

    public LocalDate getInicioChamado() {
        return this.inicioChamado;
    }

    public void setInicioChamado(LocalDate inicioChamado) {
        this.inicioChamado = inicioChamado;
    }

    public int getUrgencia() {
        return this.urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public ChamadoStatus getChamadoStatus() {
        return this.chamadoStatus;
    }

    public void setChamadoStatus(ChamadoStatus chamadoStatus) {
        this.chamadoStatus = chamadoStatus;
    }
}



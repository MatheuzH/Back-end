package Modulos;

import java.sql.Date;

public class Chamado {
    private String nomeChamado, descricao;
    private Date inicioChamado;
    private int urgencia, responsavelChamado, responsavelSolicitante;
    private Setor setor;
    private ChamadoStatus chamadoStatus;



    public Chamado(String nomeChamado, String descricao, int responsavelChamado, int urgencia, Date inicioChamado, int responsavelSolicitante, ChamadoStatus chamadoStatus, Setor setor) {
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

    public Date getInicioChamado() {
        return this.inicioChamado;
    }

    public void setInicioChamado(Date inicioChamado) {
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



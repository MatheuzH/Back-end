package Modulos;

import java.util.Date;

public class Chamado {
    private String nomeChamado, descricao, responsavelChamado, responsavelSolicitante;
    private Date inicioChamado;
    private int urgencia;
    private int chamadoStatus;


    public Chamado(String nomeChamado, String descricao, String responsavelChamado, String responsavelSolicitante, Date inicioChamado, int urgencia, int chamadoStatus) {
        this.nomeChamado = nomeChamado;
        this.descricao = descricao;
        this.responsavelChamado = responsavelChamado;
        this.responsavelSolicitante = responsavelSolicitante;
        this.inicioChamado = inicioChamado;
        this.urgencia = urgencia;
        this.chamadoStatus = chamadoStatus;
    }

    public Chamado(){

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

    public String getResponsavelChamado() {
        return this.responsavelChamado;
    }

    public void setResponsavelChamado(String responsavelChamado) {
        this.responsavelChamado = responsavelChamado;
    }

    public String getResponsavelSolicitante() {
        return this.responsavelSolicitante;
    }

    public void setResponsavelSolicitante(String responsavelSolicitante) {
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

    public int getChamadoStatus() {
        return this.chamadoStatus;
    }

    public void setChamadoStatus(int chamadoStatus) {
        this.chamadoStatus = chamadoStatus;
    }
}



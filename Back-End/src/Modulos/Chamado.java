package Modulos;

import java.time.LocalDate;

public class Chamado {
    private String nomeChamado, descricao;
    private LocalDate inicioChamado;
    private int idChamado, urgencia, responsavelChamado, responsavelSolicitante;
    private Setor setor;
    private ChamadoStatus chamadoStatus;



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

    public Chamado(int idChamado, String nomeChamado, String descricao, int responsavelChamado, int urgencia, LocalDate inicioChamado, int responsavelSolicitante, ChamadoStatus chamadoStatus, Setor setor) {
        this.idChamado = idChamado;
        this.nomeChamado = nomeChamado;
        this.descricao = descricao;
        this.responsavelChamado = responsavelChamado;
        this.responsavelSolicitante = responsavelSolicitante;
        this.inicioChamado = inicioChamado;
        this.urgencia = urgencia;
        this.chamadoStatus = chamadoStatus;
        this.setor = setor;
    }



    public Chamado(int idChamado){

    }

    public Chamado() {
        
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

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public ChamadoStatus getChamadoStatus() {
        return this.chamadoStatus;
    }

    public void setChamadoStatus(ChamadoStatus chamadoStatus) {
        this.chamadoStatus = chamadoStatus;
    }

    public void setIdChamado(int idChamado) {
    }

    public int getidChamado(){
        return this.idChamado;
    }

    @Override
    public String toString() {
       return "Id chamado: " + this.getidChamado()
                + " " + "\nNome chamado: " + this.getNomeChamado()
                + " " + "\nDescrição chamado: " + this.getDescricao()
                + " " + "\nResponsável Solicitante: " + this.getResponsavelSolicitante()
                + " " + "\nResponsável do chamado: " + this.getResponsavelChamado();
    }
}



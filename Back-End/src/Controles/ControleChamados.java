package Controles;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.ChamadosDAO;
import Modulos.Chamado;
import Modulos.ChamadoStatus;
import Modulos.Setor;


public class ControleChamados {
    ChamadosDAO chamadosDao;
   
    public ControleChamados(){
        this.chamadosDao = new ChamadosDAO();
    }

    public void criarChamado(Chamado chamado) throws SQLException{
        if(this.chamadosDao != null){
            chamadosDao.create(chamado);
            System.out.println("Chamado criado com sucesso!");
        }else {
           System.out.println("Objeto chamadosDao não foi inicializado corretamente."); 
        }
    }

    public void retornaChamados() throws SQLException{
        if(this.chamadosDao != null){
            ArrayList<Chamado> retriveAll = chamadosDao.retriveAll();
            for(Chamado chamado : retriveAll){
                System.out.println(chamado);
                System.out.println(" ");
            }
        }else {
            System.out.println("Objeto chamadosDao não foi inicializado corretamente.");
        }
    }

    public void retornaUmChamado(int idChamado) throws SQLException{
        if(this.chamadosDao != null){
            Chamado chamado = null;
            chamado = chamadosDao.retrieve(idChamado);
            if (chamado != null){
                System.out.println("Chamado encontrado:");
                System.out.println("Nome: " + chamado.getNomeChamado());
                System.out.println("Descrição: " + chamado.getDescricao());
                System.out.println("Responsável do chamado: " + chamado.getResponsavelChamado());
                System.out.println("urgência: " + chamado.getUrgencia());
                System.out.println("Início do Chamado: " + chamado.getInicioChamado());
                System.out.println("Responsável solicitante: " + chamado.getResponsavelSolicitante());
                System.out.println("Setor do chamado: " + chamado.getSetor());
                System.out.println("Status do chamado: " + chamado.getChamadoStatus());
            } else {
                System.out.println("Chamado não encontrado.");
            }
        }else {
            System.out.println("Objeto chamadosDao não foi inicializado corretamente.");
        }
    }

    public void atualizaChamado(int idChamados, String novoNomeChamado, String novaDescricao, int novoResponsavelChamado, int novoResponsavelSolicitante, LocalDate novoInicioChamado, int novaUrgencia, ChamadoStatus novoChamadoStatus, Setor novoSetor) throws SQLException{
        if(this.chamadosDao != null){
            chamadosDao.updateChamado(idChamados, novoNomeChamado, novaDescricao, novoResponsavelChamado, novoResponsavelSolicitante, novoInicioChamado, novaUrgencia, novoChamadoStatus, novoSetor);
            System.out.println("O chamado foi atualizado com sucesso!");
        }else {
            System.out.println("Objeto chamadosDao não foi inicializado corretamente.");
        }
    }

    public void deleteChamado(int idChamado) throws SQLException{
        if(this.chamadosDao != null){
            chamadosDao.deleteChamado(idChamado);
            System.out.println("Chamado deletado com sucesso!");
        }else {
            System.out.println("Objeto chamadosDao não foi inicializado corretamente.");
        }
    }
}

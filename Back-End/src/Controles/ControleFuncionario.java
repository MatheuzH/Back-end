package Controles;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.FuncionariosDAO;
import Modulos.Cargo;
import Modulos.Funcionario;
import Modulos.Setor;

public class ControleFuncionario {
    FuncionariosDAO funcionariosDao;

    public ControleFuncionario(){
        this.funcionariosDao = new FuncionariosDAO();
    }

    public void criarFuncionario(Funcionario funcionario) throws SQLException {
        if (this.funcionariosDao != null) {
            this.funcionariosDao.create(funcionario);
            System.out.println("Funcionário criado com sucesso!");
        } else {
            System.out.println("Objeto funcionariosDao não foi inicializado corretamente.");
        }

    }

    public void retornaFuncionarios() throws SQLException{
        if (this.funcionariosDao != null) {
            ArrayList<Funcionario> retriveAll = funcionariosDao.retriveAll();
            for(Funcionario funcio : retriveAll){
                System.out.println(funcio);
                System.out.println(" ");
            }
        } else {
            System.out.println("Objeto funcionariosDao não foi inicializado corretamente.");
        }
    }

    public void retornaUmFuncionario(int idFuncionario) throws SQLException{
        if (this.funcionariosDao != null) {
            Funcionario funcionario = null;
            funcionario = funcionariosDao.retrieve(idFuncionario);
            if (funcionario != null){
                System.out.println("Funcionário encontrado:");
                System.out.println("ID: " + funcionario.getId_funcionario());
                System.out.println("Email: " + funcionario.getEmail());
                System.out.println("Nome: " + funcionario.getNomeFuncionario());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Setor: " + funcionario.getId_Setor());
            } else {
                System.out.println("Funcionário não encontrado.");
            }
        }else {
            System.out.println("Objeto funcionariosDao não foi inicializado corretamente.");
        }
    }

    public void atualizarFuncionario(int idFuncionario, String novoEmail, String novoNome, Cargo novoCargo, Setor novoSetor) throws SQLException{
        if (this.funcionariosDao != null){
            funcionariosDao.updateFuncionario(idFuncionario, novoEmail, novoNome, novoCargo, novoSetor);
            System.out.println("Funcionário atualizado com sucesso!");
        }else {
            System.out.println("Objeto funcionariosDao não foi inicializado corretamente");
        }
    }

    public void deleteFuncionario(int idFuncionario) throws SQLException{
        if (this.funcionariosDao != null){
            funcionariosDao.deleteFuncionario(idFuncionario);
            System.out.println("Funcionário deletado com sucesso!");
        }else {
            System.out.println("Objeto funcionariosDao não foi inicializado corretamente");
        }
    }
}
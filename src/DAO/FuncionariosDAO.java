package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modulos.Cargo;
import Modulos.Funcionario;

public class FuncionariosDAO {

    public ArrayList<Funcionario> retriveAll() throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM funcionarios");
        ResultSet rst = stm.getResultSet();
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        while (rst.next()){
            int id_funcionario = rst.getInt("id_funcionario");
            int cargo = rst.getInt("cargo");
            int fk_setor = rst.getInt("fk_setor");
            String email = rst.getString("email");
            String nome = rst.getString("nomeFuncionario");
            String senha = rst.getString("senha");
            Funcionario funcionario = new Funcionario(id_funcionario,email,nome,cargo,senha,fk_setor);
            funcionarios.add(funcionario);
        }
        connection.close();
        return funcionarios;
    }

    public Funcionario retrive() throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO funcionarios (email, nomeFuncionario, cargo, senha, fk_setor ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {

            stm.execute("SELECT * FROM funcionarios ");
        ResultSet rst = stm.getResultSet();
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        while (rst.next()){
            int id_funcionario = rst.getInt("id_funcionario");
            int cargo = rst.getInt("cargo");
            int fk_setor = rst.getInt("fk_setor");
            String email = rst.getString("email");
            String nome = rst.getString("nomeFuncionario");
            String senha = rst.getString("senha");
            Funcionario funcionario = new Funcionario(id_funcionario,email,nome,cargo,senha,fk_setor);
            funcionarios.add(funcionario);
        }
        connection.close();
        return funcionarios;
    }

    public boolean create(Funcionario funcionarios) throws SQLException{

        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO funcionarios (email, nomeFuncionario, cargo, senha, fk_setor ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1,funcionarios.getEmail());
            pstm.setString(2,funcionarios.getNomeFuncionario());
            pstm.setInt(3,funcionarios.getCargos());
            pstm.setString(4,funcionarios.getSenha());
            pstm.setInt(5,funcionarios.getId_Setor());

            return pstm.execute();
        }

    }

    public boolean update(Funcionario funcionario) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "UPDATE back-end.funcionarios SET email = ?, nomeFuncionario = ?, cargo = ?, senha = ?, fk_setor = ? WHERE id_funcionario = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setString(1,funcionario.getEmail());
            pstm.setString(2,funcionario.getNomeFuncionario());
            pstm.setInt(3,funcionario.getCargo());
            pstm.setString(4,funcionario.getSenha());
            pstm.setInt(5,funcionario.getId_Setor());
            pstm.setInt(6,funcionario.getId_funcionario());

            return pstm.execute();
        }
    }

    public boolean delete(Funcionario funcionarioDelete) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "DELETE FROM back-end.Funcionarios WHERE id_funcionario = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(1, funcionarioDelete.getId_funcionario());
            return pstm.execute();
        }
    }

}


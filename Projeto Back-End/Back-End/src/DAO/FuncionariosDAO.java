package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modulos.Cargos;
import Modulos.Funcionarios;

public class FuncionariosDAO {

    public ArrayList<Funcionarios> retriveAll() throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM funcionarios");
        ResultSet rst = stm.getResultSet();
        ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
        while (rst.next()){
            int id_funcionario = rst.getInt("id_funcionario");
            int cargo = rst.getInt("cargo");
            int fk_setor = rst.getInt("fk_setor");
            String email = rst.getString("email");
            String nome = rst.getString("nomeFuncionario");
            String senha = rst.getString("senha");
            Funcionarios funcionario = new Funcionarios(id_funcionario,email,nome,cargo,senha,fk_setor);
            funcionarios.add(funcionario);
        }
        connection.close();
        return funcionarios;

    }

    public boolean create(Funcionarios funcionarios) throws SQLException{
           
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO funcionarios (id_funcionario, email, nomeFuncionario, cargo, senha, fk_setor ) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setInt(1,funcionarios.getId_funcionario());
            pstm.setString(2,funcionarios.getEmail());
            pstm.setString(3,funcionarios.getNomeFuncionario());
            pstm.setInt(4,funcionarios.getCargos());
            pstm.setString(5,funcionarios.getSenha());
            pstm.setInt(6,funcionarios.getId_Setor());
            
            return pstm.execute();
        }  

    }

    public static boolean update(Funcionarios funcionarioUpdate) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "UPDATE back-end.funcionarios SET email = ?, nomeFuncionario = ?, cargo = ?, senha = ?, fk_setor = ? WHERE id_funcionario = ?";

        Funcionarios funcionarios = new Funcionarios();

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(6,funcionarios.getId_funcionario());
            pstm.setString(1,funcionarios.getEmail());
            pstm.setString(2,funcionarios.getNomeFuncionario());
            pstm.setInt(3,funcionarios.getCargos());
            pstm.setString(4,funcionarios.getSenha());
            pstm.setInt(5,funcionarios.getId_Setor());

            return pstm.execute();
        }
    }

    public static boolean delete(Funcionarios funcionarioDelete) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "DELETE FROM back-end.Funcionarios WHERE id_funcionario = ?";
            
        Funcionarios funcionarios = new Funcionarios(1);

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(1, funcionarioDelete.getId_funcionario());
            pstm.execute();
            ResultSet prst = pstm.getResultSet();
            return pstm.execute();
        }
    }

}


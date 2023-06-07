package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modulos.Cargo;
//import Modulos.Cargo;
import Modulos.Funcionario;
import Modulos.Setor;

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
            int cargoInt = rst.getInt("cargo");
            Cargo cargo = Cargo.values()[cargoInt];
            int fk_setorInt = rst.getInt("fk_setor");
            Setor setor = Setor.values()[fk_setorInt];
            String email = rst.getString("email");
            String nome = rst.getString("nomeFuncionario");
            String senha = rst.getString("senha");
            Funcionario funcionario = new Funcionario(id_funcionario,email,nome,cargo,senha,setor);
            funcionarios.add(funcionario);
        }
        connection.close();
        return funcionarios;
    }

    // public Funcionario retrieve(int id_funcionario) throws SQLException{
    //     CriaConexao criaConexao = new CriaConexao();
    //     Connection connection = criaConexao.recuperarConexao();
    //     PreparedStatement stm = null;
    //     ResultSet resultSet = null;

    //     try {
    //         String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ?";
    //         stm = connection.prepareStatement(sql);
    //         stm.setInt(1, id_funcionario);

    //         stm.execute();

    //         resultSet = stm.getResultSet();

    //         if (resultSet.next()) {
    //             Funcionario funcionario = new Funcionario();
    //             funcionario.setId_funcionario(resultSet.getInt("id_funcionario"));
    //             funcionario.setEmail(resultSet.getString("email"));
    //             funcionario.setNomeFuncionario(resultSet.getString("nomeFuncionario"));
    //             funcionario.setCargo(resultSet.getObject("cargo"));
    //             funcionario.setSenha(resultSet.getString("senha"));
    //             funcionario.setId_Setor(resultSet.getInt("fk_setor"));
    //             return funcionario;
    //         }

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null; 
    //     } finally {
    //         if (resultSet != null) {
    //             try {
    //                 resultSet.close();
    //             } catch (SQLException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         if (stm != null) {
    //             try {
    //                 stm.close();
    //             } catch (SQLException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         if (connection != null) {
    //             try {
    //                 connection.close();
    //             } catch (SQLException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    //     return null;
    // }

    public boolean create(Funcionario funcionarios) throws SQLException{

        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO funcionarios (email, nomeFuncionario, cargo, senha, fk_setor ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1,funcionarios.getEmail());
            pstm.setString(2,funcionarios.getNomeFuncionario());
            pstm.setInt(3,funcionarios.getCargos().cargos);
            pstm.setString(4,funcionarios.getSenha());
            pstm.setInt(5,funcionarios.getId_Setor().dbValue);

            return pstm.execute();
        }

    }

    // public boolean update(Funcionario funcionario) throws SQLException{
    //     CriaConexao criaConexao = new CriaConexao();
    //     Connection connection = criaConexao.recuperarConexao();

    //     String sql = "UPDATE back-end.funcionarios SET email = ?, nomeFuncionario = ?, cargo = ?, senha = ?, fk_setor = ? WHERE id_funcionario = ?";

    //     try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
    //         pstm.setString(1,funcionario.getEmail());
    //         pstm.setString(2,funcionario.getNomeFuncionario());
    //         pstm.setInt(3,funcionario.getCargo());
    //         pstm.setString(4,funcionario.getSenha());
    //         pstm.setInt(5,funcionario.getId_Setor());
    //         pstm.setInt(6,funcionario.getId_funcionario());

    //         return pstm.execute();
    //     }
    // }

    public boolean deleteFuncionario(int id_funcionario) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        PreparedStatement pstm = null;

        String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id_funcionario);

            int rowsAffected = pstm.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}





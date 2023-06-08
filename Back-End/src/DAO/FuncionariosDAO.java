package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controles.CriaConexao;
import Modulos.Cargo;
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
            Cargo cargo = Cargo.fromValue(cargoInt);
            int setorInt = rst.getInt("fk_setor");
            Setor setor = Setor.fromValue(setorInt);
            String email = rst.getString("email");
            String nome = rst.getString("nomeFuncionario");
            String senha = rst.getString("senha");
            Funcionario funcionario = new Funcionario(id_funcionario,email,nome,cargo,senha,setor);
            funcionarios.add(funcionario);
        }
        connection.close();
        return funcionarios;
    }

    public Funcionario retrieve(int idFuncionario) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
    
        try (Connection connection = criaConexao.recuperarConexao();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM funcionarios WHERE id_funcionario = ?")) {
            
            statement.setInt(1, idFuncionario);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String email = resultSet.getString("email");
                    String nomeFuncionario = resultSet.getString("nomeFuncionario");
                    int cargoValue = resultSet.getInt("cargo");
                    int setorValue = resultSet.getInt("fk_setor");
    
                    Cargo cargo = Cargo.fromValue(cargoValue);
                    Setor setor = Setor.fromValue(setorValue);
    
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId_funcionario(idFuncionario);
                    funcionario.setEmail(email);
                    funcionario.setNomeFuncionario(nomeFuncionario);
                    funcionario.setCargo(cargo);
                    funcionario.setId_Setor(setor);
    
                    return funcionario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null;
    }
    

    public boolean create(Funcionario funcionarios) throws SQLException{

        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO funcionarios (email, nomeFuncionario, cargo, senha, fk_setor ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1,funcionarios.getEmail());
            pstm.setString(2,funcionarios.getNomeFuncionario());
            pstm.setInt(3,funcionarios.getCargo().cargos);
            pstm.setString(4,funcionarios.getSenha());
            pstm.setInt(5,funcionarios.getId_Setor().dbValue);

            return pstm.execute();
        }

    }

    public boolean updateFuncionario(int idFuncionario, String novoEmail, String novoNome, Cargo novoCargo, Setor novoSetor) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        try (Connection connection = criaConexao.recuperarConexao();
             PreparedStatement pstm = connection.prepareStatement("UPDATE funcionarios SET email = ?, nomeFuncionario = ?, cargo = ?, fk_setor = ? WHERE id_funcionario = ?")) {
    
            pstm.setString(1, novoEmail);
            pstm.setString(2, novoNome);
            pstm.setInt(3, novoCargo.getValue());
            pstm.setInt(4, novoSetor.getValue());
            pstm.setInt(5, idFuncionario);
    
            int rowsAffected = pstm.executeUpdate();
    
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

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
        } 
    }
}





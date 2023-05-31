package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modulos.Chamado;
import Modulos.ChamadoStatus;

public class ChamadosDAO {
    public ArrayList<Chamado> retriveAll() throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM chamados");
        ResultSet rst = stm.getResultSet();
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        while (rst.next()){
            int urgencia = rst.getInt("urgencia");
            String nomeChamado = rst.getString("nomeChamado");
            String descricao = rst.getString("descricao");
            String responsavelChamado = rst.getString("responsavelChamado");
            String responsavelSolicitante = rst.getString("responsavelSolicitante");
            Date inicioChamado = rst.getDate("inicioChamado");
            int chamadoStatus = rst.getInt();
            Chamado chamado = new Chamado(nomeChamado, descricao, responsavelChamado, responsavelSolicitante, inicioChamado, urgencia, chamadoStatus);
            chamados.add(chamado);
        }
        connection.close();
        return chamados;
    }

    public Chamado retrieve(int id_chamado) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        PreparedStatement stm = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM chamados WHERE id_chamado = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id_chamado);

            stm.execute();

            resultSet = stm.getResultSet();

            if (resultSet.next()) {
                Chamado chamado = new Chamado();
                chamado.setId_chamado(resultSet.getInt("id_chamado"));
                chamado.setEmail(resultSet.getString("email"));
                chamado.setNomechamado(resultSet.getString("nomechamado"));
                chamado.setCargo(resultSet.getInt("cargo"));
                chamado.setSenha(resultSet.getString("senha"));
                chamado.setId_Setor(resultSet.getInt("fk_setor"));
                return chamado;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stm != null) {
                try {
                    stm.close();
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
        return null;
    }

    public boolean create(Chamado chamados) throws SQLException{

        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO chamados (email, nomechamado, cargo, senha, fk_setor ) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1,chamados.getEmail());
            pstm.setString(2,chamados.getNomechamado());
            pstm.setInt(3,chamados.getCargos());
            pstm.setString(4,chamados.getSenha());
            pstm.setInt(5,chamados.getId_Setor());

            return pstm.execute();
        }

    }

    public boolean update(Chamado chamado) throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "UPDATE back-end.funcionarios SET email = ?, nomeFuncionario = ?, cargo = ?, senha = ?, fk_setor = ? WHERE id_funcionario = ?";

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setString(1,chamado.getEmail());
            pstm.setString(2,chamado.getNomeChamado());
            pstm.setInt(3,chamado.getCargo());
            pstm.setString(4,chamado.getSenha());
            pstm.setInt(5,chamado.getId_Setor());
            pstm.setInt(6,chamado.getId_chamado());

            return pstm.execute();
        }
    }
}

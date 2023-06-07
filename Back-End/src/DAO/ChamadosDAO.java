package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Modulos.Chamado;
import Modulos.ChamadoStatus;
import Modulos.Setor;

public class ChamadosDAO {
    public ArrayList<Chamado> retriveAll() throws SQLException{
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM chamados");
        ResultSet rst = stm.getResultSet();
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        while (rst.next()){
            int urgencia = rst.getInt("fk_urgencia");
            String nomeChamado = rst.getString("nomeChamado");
            String descricao = rst.getString("descricao");
            int responsavelChamado = rst.getInt("responsavelChamado");
            int responsavelSolicitante = rst.getInt("responsavelSolicitante");
            Date inicioChamado = rst.getDate("inicioChamado");
            int chamadoStatusInt = rst.getInt("fk_chamadoStatus");
            ChamadoStatus status = ChamadoStatus.fromValue(chamadoStatusInt);
            int setorInt = rst.getInt("fk_setor");
            Setor setor = Setor.fromValue(setorInt);
            Chamado chamado = new Chamado(nomeChamado, descricao, responsavelChamado,
            responsavelSolicitante, (java.sql.Date) inicioChamado, urgencia, status, setor);
            chamados.add(chamado);
        }
        connection.close();
        return chamados;
    }

    // public Chamado retrieve(int id_chamado) throws SQLException{
    //     CriaConexao criaConexao = new CriaConexao();
    //     Connection connection = criaConexao.recuperarConexao();
    //     PreparedStatement stm = null;
    //     ResultSet resultSet = null;

    //     try {
    //         String sql = "SELECT * FROM chamados WHERE id_chamado = ?";
    //         stm = connection.prepareStatement(sql);
    //         stm.setInt(1, id_chamado);

    //         stm.execute();

    //         resultSet = stm.getResultSet();

    //         if (resultSet.next()) {
    //             Chamado chamado = new Chamado();
    //             chamado.setId_chamado(resultSet.getInt("id_chamado"));
    //             chamado.setEmail(resultSet.getString("email"));
    //             chamado.setNomechamado(resultSet.getString("nomechamado"));
    //             chamado.setCargo(resultSet.getInt("cargo"));
    //             chamado.setSenha(resultSet.getString("senha"));
    //             chamado.setId_Setor(resultSet.getInt("fk_setor"));
    //             return chamado;
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

    public boolean create(Chamado chamados) throws SQLException{

        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();

        String sql = "INSERT INTO chamados (nomeChamado, descricao, responsavelChamado, fk_urgencia, inicioChamado, responsavelSolicitante, fk_setor, fk_chamadoStatus ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)) {
            pstm.setString(1,chamados.getNomeChamado());
            pstm.setString(2,chamados.getDescricao());
            pstm.setInt(3,chamados.getResponsavelChamado());
            pstm.setInt(4,chamados.getUrgencia());
            pstm.setObject(5, chamados.getInicioChamado());
            pstm.setInt(6, chamados.getResponsavelSolicitante());
            pstm.setInt(7, chamados.getSetor().dbValue);
            pstm.setInt(8, chamados.getChamadoStatus().statusChamado);

            return pstm.execute();
        }

    }

    public boolean deleteChamado(int id_chamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        Connection connection = criaConexao.recuperarConexao();
        PreparedStatement pstm = null;

        String sql = "DELETE FROM chamados WHERE id_chamados = ?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id_chamado);

            int rowsAffected = pstm.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }

}

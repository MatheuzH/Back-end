package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Controles.CriaConexao;
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

    public Chamado retrieve(int idChamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        
        try (Connection connection = criaConexao.recuperarConexao();
             PreparedStatement pstm = connection.prepareStatement("SELECT * FROM chamados WHERE id_chamados = ?")) {
            
            pstm.setInt(1, idChamado);
            
            try (ResultSet resultSet = pstm.executeQuery()) {
                if (resultSet.next()) {
                    String nomeChamado = resultSet.getString("nomeChamado");
                    String descricao = resultSet.getString("descricao");
                    int responsavelChamado = resultSet.getInt("responsavelChamado");
                    int responsavelSolicitante = resultSet.getInt("responsavelSolicitante");
                    Date inicioChamado = resultSet.getDate("inicioChamado");
                    int urgencia = resultSet.getInt("urgencia");
                    ChamadoStatus status = ChamadoStatus.valueOf(resultSet.getString("chamadoStatus"));
                    Setor setor = Setor.valueOf(resultSet.getString("setor"));
                    
                    Chamado chamado = new Chamado(nomeChamado, descricao, responsavelChamado, urgencia, (java.sql.Date) inicioChamado, responsavelSolicitante,  status, setor);
                    chamado.setIdChamado(idChamado);
                    
                    return chamado;
                }
            }
        }
        
        return null;
    }
    
    public boolean updateChamadoById(int idChamado, String novoNomeChamado, String novaDescricao, String novoResponsavelChamado, String novoResponsavelSolicitante, Date novoInicioChamado, int novaUrgencia, ChamadoStatus novoChamadoStatus, Setor novoSetor) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        
        try (Connection connection = criaConexao.recuperarConexao();
             PreparedStatement pstm = connection.prepareStatement("UPDATE chamados SET nomeChamado = ?, descricao = ?, responsavelChamado = ?, responsavelSolicitante = ?, inicioChamado = ?, urgencia = ?, chamadoStatus = ?, setor = ? WHERE id_chamado = ?")) {
            
            pstm.setString(1, novoNomeChamado);
            pstm.setString(2, novaDescricao);
            pstm.setString(3, novoResponsavelChamado);
            pstm.setString(4, novoResponsavelSolicitante);
            pstm.setDate(5, new java.sql.Date(novoInicioChamado.getTime()));
            pstm.setInt(6, novaUrgencia);
            pstm.setString(7, novoChamadoStatus.name());
            pstm.setString(8, novoSetor.name());
            pstm.setInt(9, idChamado);
            
            int rowsAffected = pstm.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    

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

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


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
            int idChamado = rst.getInt("id_chamados");
            int urgencia = rst.getInt("fk_urgencia");
            String nomeChamado = rst.getString("nomeChamado");
            String descricao = rst.getString("descricao");
            int responsavelChamado = rst.getInt("responsavelChamado");
            int responsavelSolicitante = rst.getInt("responsavelSolicitante");
            LocalDate inicioChamado = rst.getObject("inicioChamado", LocalDate.class);
            int chamadoStatusInt = rst.getInt("fk_chamadoStatus");
            ChamadoStatus status = ChamadoStatus.fromValue(chamadoStatusInt);
            int setorInt = rst.getInt("fk_setor");
            Setor setor = Setor.fromValue(setorInt);
            Chamado chamado = new Chamado(idChamado, nomeChamado, descricao, responsavelChamado,
            responsavelSolicitante, inicioChamado, urgencia, status, setor);
            chamados.add(chamado);
        }
        connection.close();
        return chamados;
    }

    public Chamado retrieve(int idChamado) throws SQLException {
        CriaConexao criaConexao = new CriaConexao();
        
        try (Connection connection = criaConexao.recuperarConexao();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM chamados WHERE id_chamados = ?")) {
            
            statement.setInt(1, idChamado);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int idChamados = resultSet.getInt("id_chamados");
                    String nomeChamado = resultSet.getString("nomeChamado");
                    String descricao = resultSet.getString("descricao");
                    int responsavelChamado = resultSet.getInt("responsavelChamado");
                    int urgencia = resultSet.getInt("fk_urgencia");
                    LocalDate inicioChamado = resultSet.getObject("inicioChamado", LocalDate.class);
                    int responsavelSolicitante = resultSet.getInt("responsavelSolicitante");
                    int setorValue = resultSet.getInt("fk_setor");
                    int chamadoStatusValue = resultSet.getInt("fk_chamadoStatus");

                    Setor setor = Setor.fromValue(setorValue);
                    ChamadoStatus status = ChamadoStatus.fromValue(chamadoStatusValue);
                    
                    
                    Chamado chamado = new Chamado();
                    chamado.setIdChamado(idChamados);
                    chamado.setNomeChamado(nomeChamado);
                    chamado.setDescricao(descricao);
                    chamado.setResponsavelChamado(responsavelChamado);
                    chamado.setUrgencia(urgencia);
                    chamado.setInicioChamado(inicioChamado);
                    chamado.setResponsavelSolicitante(responsavelSolicitante);
                    chamado.setSetor(setor);
                    chamado.setChamadoStatus(status);

                    return chamado;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
    
    public boolean updateChamado(int idChamados, String novoNomeChamado, String novaDescricao, int novoResponsavelChamado, int novoResponsavelSolicitante, LocalDate novoInicioChamado, int novaUrgencia, ChamadoStatus novoChamadoStatus, Setor novoSetor) throws SQLException {
    CriaConexao criaConexao = new CriaConexao();

    try (Connection connection = criaConexao.recuperarConexao();
         PreparedStatement pstm = connection.prepareStatement("UPDATE chamados SET nomeChamado = ?, descricao = ?, responsavelChamado = ?, fk_urgencia = ?, inicioChamado = ?, responsavelSolicitante = ?, fk_setor = ?, fk_chamadoStatus = ? WHERE id_chamados = ?")) {

        pstm.setString(1, novoNomeChamado);
        pstm.setString(2, novaDescricao);
        pstm.setInt(3, novoResponsavelChamado);
        pstm.setInt(4, novaUrgencia);
        pstm.setObject(5, java.sql.Date.valueOf(novoInicioChamado));
        pstm.setInt(6, novoResponsavelSolicitante);
        pstm.setInt(7, novoSetor.getValue());
        pstm.setInt(8, novoChamadoStatus.getValue());
        pstm.setInt(9, idChamados);

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

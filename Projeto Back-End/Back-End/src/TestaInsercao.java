import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaInsercao {
    public static void main (String[] args) throws SQLException{
        CriarConexao criaConexao = new CriarConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        stm.execute("INSERT INTO Obras (nome) VALUES (‘Anti-Hero’)", Statement.RETURN_GENERATED_KEYS);
        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
        }
        connection.close();
    }
}
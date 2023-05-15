import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws Exception {
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        boolean resultado = stm.execute("SELECT id_funcionario, email FROM funcionarios");
        ResultSet rst = stm.getResultSet();
        while (rst.next()){
            Integer id = rst.getInt("id_funcionario");
            String email = rst.getString("email");
            System.out.println(id);
            System.out.println(email);
        }
        connection.close();
    }
}

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncinariosDAO {



    ArrayList<Funcionarios> retriveAll() throws SQLException{
        CriarConexao criaConexao = new CriarConexao();
        Connection connection = criaConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM funcionarios");
        ResultSet rst = stm.getResultSet();
        ArrayList<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
        while (rst.next()){
            String cpf = rst.getString("cpf");
            String nome = rst.getString("nome");
            Date data = rst.getDate("data_nascimento");
            int idade = rst.getInt("idade");
            Funcionarios f = new Funcionarios(nome, cpf, data, idade);
            funcionarios.add(f);
        }
        connection.close();
        return funcionarios;





    }

}

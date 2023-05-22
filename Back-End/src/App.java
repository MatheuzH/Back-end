import java.util.ArrayList;

import DAO.FuncionariosDAO;
import Modulos.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        Funcionario f1 = new Funcionario(1, "matheus@", "matheus", 1, "1234", 1);

        System.out.println(f1.getNomeFuncionario());

        FuncionariosDAO funcionario = new FuncionariosDAO();

        funcionario.create(f1);

        //ArrayList<Funcionario> func = funcionario.retriveAll();

        //for(Funcionario funcio : func) {
        //    System.out.println(funcio.getNomeFuncionario());
        //}
    }
}

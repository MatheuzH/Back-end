import java.util.ArrayList;

import DAO.FuncionariosDAO;
import Modulos.Funcionarios;

public class App {
    public static void main(String[] args) throws Exception {
        Funcionarios f1 = new Funcionarios(1, "matheus@", "matheus", 1, "1234", 1);
    

        System.out.println(f1.getId_funcionario());

        FuncionariosDAO funcionario = new FuncionariosDAO();

        funcionario.create(f1);

        ArrayList<Funcionarios> func = funcionario.retriveAll();

        for(Funcionarios funcio : func) {
            System.out.println(funcio.getNomeFuncionario());
        }
    }
}

import java.util.ArrayList;

import DAO.FuncionariosDAO;
import Modulos.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        Funcionario f1 = new Funcionario("@matheus", "matheus", 1, "1234", 1);
        Funcionario f2 = new Funcionario("@gabriel", "gabriel", 2, "1234", 2);
        Funcionario f3 = new Funcionario("@constant", "constant", 3, "1234", 3);


        FuncionariosDAO funcionario = new FuncionariosDAO();

        //funcionario.create(f1);
        //funcionario.create(f2);
        //funcionario.create(f3);
        funcionario.retrieve(2);


         //ArrayList<Funcionario> retriveall = funcionario.retriveAll();

         //for(Funcionario funcio : retriveall) {
         //System.out.println(funcio.getNomeFuncionario());
        //}
    }
}

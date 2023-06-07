import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.plaf.synth.SynthSpinnerUI;

import DAO.ChamadosDAO;
import DAO.FuncionariosDAO;
import Modulos.Funcionario;
import Modulos.Setor;
import Modulos.Cargo;
import Modulos.Chamado;
import Modulos.ChamadoStatus;


public class App {
    public static void main(String[] args) throws Exception{
    
      //Funcionario f1 = new Funcionario("@matheus", "matheus", Cargo.ANALISTATI, "1234", 1);
      //Funcionario f2 = new Funcionario("@gabriel", "gabriel", Cargo.ADMSIS, "1234", 2);
      //Funcionario f3 = new Funcionario("@constant", "constant", Cargo.GESTORCOMERCIAL, "1234", 3);
    //  Chamado chamado = new Chamado("teste","Estou testando o create",1,1,LocalDate.of(2023, 06, 05),2,ChamadoStatus.ABERTO,Setor.TI);

     FuncionariosDAO funcionario = new FuncionariosDAO();
    //  ChamadosDAO criarChamado = new ChamadosDAO();

         //criarChamado.create(chamado);
         //funcionario.create(f1);
         //funcionario.create(f2);
         //funcionario.create(f3);
        // funcionario.retrieve(2);
        


        ArrayList<Funcionario> retriveall = funcionario.retriveAll();

        for(Funcionario funcio : retriveall) {
        System.out.println(funcio.getNomeFuncionario());
        System.out.println(funcio.getId_funcionario());
        }
    }
}

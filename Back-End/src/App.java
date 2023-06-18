
import java.time.LocalDate;

import Controles.ControleChamados;
import Controles.ControleFuncionario;
import Modulos.Chamado;
import Modulos.ChamadoStatus;
import Modulos.Setor;

public class App {
    public static void main(String[] args) throws Exception{
      // Funcionario funcionario = new Funcionario("theo@", "theo",Cargo.ANALISTATI,"78392k@al",Setor.TI);
      Chamado chamado = new Chamado("teste2", "estou testando denovo", 7, 1, LocalDate.of(2023, 06, 18), 9, ChamadoStatus.ABERTO, Setor.OPERACOES);
      ControleFuncionario controleFun = new ControleFuncionario();
      ControleChamados controleCham = new ControleChamados();


      controleCham.retornaUmChamado(9);

      // controleFun.criarFuncionario(funcionario);
      // controleFun.retornaFuncionario();
  }
}

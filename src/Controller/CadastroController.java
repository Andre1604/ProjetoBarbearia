package Controller;

import Model.Banco.FuncionarioBanco;
import Model.Cliente;
import Model.Funcionario;
import View.Menu;

public class CadastroController {
    private final Menu view;
    private CadastroHelper helper;
    public CadastroController(Menu view) {
        this.view = view;
    }
    public void entrarNoSistema(){
        Cliente cliente = helper.obterModelo();
        FuncionarioBanco funcionarioBanco = new FuncionarioBanco();
        Funcionario funcionarioAutenticado = funcionarioBanco.selecionarNomeSenha(funcionarioBanco);

        if (funcionarioAutenticado != null) {
            Menu menu = new Menu();
        }
        else {
            System.out.println("Usuário ou senha inválido");
        }
    }
}

package Controller;

import Model.Funcionario;
import View.FuncionarioView;

// FuncionarioController.java
public class FuncionarioController {
    private Funcionario model;
    private FuncionarioView view;

    public FuncionarioController(Funcionario model, FuncionarioView view) {
        this.model = model;
        this.view = view;
    }

    public void setNomeFuncionario(String nome) {
        model.setNome(nome);
    }

    public String getNomeFuncionario() {
        return model.getNome();
    }

    public void setFuncaoFuncionario(String funcao) {
        model.setFuncao(funcao);
    }

    public String getFuncaoFuncionario() {
        return model.getFuncao();
    }


    public void atualizarView() {
        view.exibirDetalhesFuncionario(model.getNome(), model.getFuncao());
    }
}


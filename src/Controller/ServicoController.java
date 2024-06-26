package Controller;

import Model.Servico;
import View.ServicoView;

// ServicoController.java
public class ServicoController {
    private Servico model;
    private ServicoView view;

    public ServicoController(Servico model, ServicoView view) {
        this.model = model;
        this.view = view;
    }

    public void setDescricaoServico(String descricao) {
        model.setDescricao(descricao);
    }

    public String getDescricaoServico() {
        return model.getDescricao();
    }

    public void setPrecoServico(double preco) {
        model.setPreco(preco);
    }

    public double getPrecoServico() {
        return model.getPreco();
    }

    public void atualizarView() {
        view.exibirDetalhesServico(model.getDescricao(), model.getPreco());
    }
}

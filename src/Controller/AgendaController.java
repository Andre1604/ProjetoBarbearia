package Controller;

// AgendaController.java
import Model.Agenda;
import Model.Cliente;
import Model.Funcionario;
import Model.Servico;
import View.AgendaView;

import java.util.Date;

public class AgendaController {
    private Agenda model;
    private AgendaView view;

    public AgendaController(Agenda model, AgendaView view) {
        this.model = model;
        this.view = view;
    }

    public void setClienteAgenda(Cliente cliente) {
        model.setCliente(cliente);
    }

    public Cliente getClienteAgenda() {
        return model.getCliente();
    }

    public void setFuncionarioAgenda(Funcionario funcionario) {
        model.setFuncionario(funcionario);
    }

    public Funcionario getFuncionarioAgenda() {
        return model.getFuncionario();
    }

    public void setServicoAgenda(Servico servico) {
        model.setServico(servico);
    }

    public Servico getServicoAgenda() {
        return model.getServico();
    }

    public void setDataAgenda(Date data) {
        model.setData(data);
    }

    public Date getDataAgenda() {
        return model.getData();
    }

    public void atualizarView() {
        view.exibirDetalhesAgenda(model.getCliente().getNome(), model.getFuncionario().getNome(), model.getServico().getDescricao(), model.getData());
    }
}

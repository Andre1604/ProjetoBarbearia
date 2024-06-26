package Model.Banco;

import Model.Agenda;
import Model.Cliente;
import Model.Funcionario;
import Model.Servico;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AgendaDAO {
    private String agendaDAO;
    public AgendaDAO(String agendaDAO) {
        this.agendaDAO = agendaDAO;
    }
    public ArrayList<Agenda> carregarAgendas(ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios, ArrayList<Servico> servicos) {
        ArrayList<Agenda> agendas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try (BufferedReader reader = new BufferedReader(new FileReader(agendaDAO))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int clienteIndex = Integer.parseInt(data[0].trim());
                    int funcionarioIndex = Integer.parseInt(data[1].trim());
                    int servicoIndex = Integer.parseInt(data[2].trim());
                    Date dataAgenda = sdf.parse(data[3].trim());

                    if (clienteIndex >= 0 && clienteIndex < clientes.size() &&
                            funcionarioIndex >= 0 && funcionarioIndex < funcionarios.size() &&
                            servicoIndex >= 0 && servicoIndex < servicos.size()) {

                        Cliente cliente = clientes.get(clienteIndex);
                        Funcionario funcionario = funcionarios.get(funcionarioIndex);
                        Servico servico = servicos.get(servicoIndex);

                        Agenda agenda = new Agenda(cliente, funcionario, servico, dataAgenda);
                        agendas.add(agenda);
                    }
                }
            }
        } catch (IOException | java.text.ParseException e) {
            System.out.println("Erro ao carregar agendas do arquivo: " + e.getMessage());
        }

        return agendas;
    }

    // Método para salvar agendas no arquivo
    public void salvarAgendas(ArrayList<Agenda> agendas) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(agendaDAO))) {
            for (Agenda agenda : agendas) {
                int clienteId = agenda.getCliente().getId();
                int funcionarioId = agenda.getFuncionario().getId();
                int servicoId = agenda.getServico().getId();
                String dataAgendaStr = sdf.format(agenda.getData());

                writer.write(clienteId + ", " + funcionarioId + ", " + servicoId + ", " + dataAgendaStr);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar agendas no arquivo: " + e.getMessage());
        }
    }
}


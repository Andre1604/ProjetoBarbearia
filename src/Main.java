import Model.Agenda;
import Model.Banco.AgendaDAO;
import Model.Banco.ClientesDAO;
import Model.Banco.FuncionarioDAO;
import Model.Banco.ServicoDAO;
import Model.Cliente;
import Model.Funcionario;
import Model.Servico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Servico> servicos = new ArrayList<>();
        ArrayList<Agenda> agendas = new ArrayList<>();

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Cliente");
            System.out.println("2. Funcionario");
            System.out.println("3. Servico");
            System.out.println("4. Agenda");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        clienteMenu(scanner, clientes);
                        break;
                    case 2:
                        funcionarioMenu(scanner, funcionarios);
                        break;
                    case 3:
                        servicoMenu(scanner, servicos);
                        break;
                    case 4:
                        agendaMenu(scanner, agendas, clientes, funcionarios, servicos);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }
    }

    public static void clienteMenu(Scanner scanner, ArrayList<Cliente> cliente) {
        while (true) {
            ClientesDAO clienteDAO = new ClientesDAO("clientes.txt");
            ArrayList<Cliente> clientes = clienteDAO.carregarClientes();

            System.out.println("\nMenu Cliente:");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Ler Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();
                        Cliente novoCliente = new Cliente(nome, telefone);
                        clientes.add(novoCliente);
                        System.out.println("Cliente criado com sucesso!");
                        clienteDAO.salvarClientes(clientes);

                        break;
                    case 2:
                        System.out.println("\nLista de Clientes:");
                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente clientee = clientes.get(i);
                            System.out.println("[" + i + "] Nome: " + clientee.getNome() + ", Telefone: " + clientee.getTelefone());
                        }
                        clienteDAO.salvarClientes(clientes);
                        break;
                    case 3:
                        System.out.print("Índice do Cliente a ser atualizado: ");
                        int indexAtualizar = Integer.parseInt(scanner.nextLine());
                        if (indexAtualizar >= 0 && indexAtualizar < clientes.size()) {
                            Cliente clienteAtualizar = clientes.get(indexAtualizar);
                            System.out.print("Novo Nome: ");
                            clienteAtualizar.setNome(scanner.nextLine());
                            System.out.print("Novo Telefone: ");
                            clienteAtualizar.setTelefone(scanner.nextLine());
                            System.out.println("Cliente atualizado com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        clienteDAO.salvarClientes(clientes);
                        break;
                    case 4:
                        System.out.print("Índice do Cliente a ser deletado: ");
                        int indexDeletar = Integer.parseInt(scanner.nextLine());
                        if (indexDeletar >= 0 && indexDeletar < clientes.size()) {
                            clientes.remove(indexDeletar);
                            System.out.println("Cliente deletado com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        clienteDAO.salvarClientes(clientes);
                        break;
                    case 5:
                        clienteDAO.salvarClientes(clientes);
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }
    }

    public static void funcionarioMenu(Scanner scanner, ArrayList<Funcionario> funcionario) {
        while (true) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO("funcionarios.txt");
            ArrayList<Funcionario> funcionarios = funcionarioDAO.carregarFuncionarios();

            System.out.println("\nMenu Funcionario:");
            System.out.println("1. Criar Funcionario");
            System.out.println("2. Ler Funcionarios");
            System.out.println("3. Atualizar Funcionario");
            System.out.println("4. Deletar Funcionario");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Função: ");
                        String funcao = scanner.nextLine();
                        Funcionario novoFuncionario = new Funcionario(nome, funcao);
                        funcionarios.add(novoFuncionario);
                        System.out.println("Funcionario criado com sucesso!");
                        funcionarioDAO.salvarFuncionarios(funcionarios);
                        break;
                    case 2:
                        System.out.println("\nLista de Funcionarios:");
                        for (int i = 0; i < funcionarios.size(); i++) {
                            Funcionario funcionarioo = funcionarios.get(i);
                            System.out.println("[" + i + "] Nome: " + funcionarioo.getNome() + ", Função: " + funcionarioo.getFuncao());
                        }
                        funcionarioDAO.salvarFuncionarios(funcionarios);
                        break;
                    case 3:
                        System.out.print("Índice do Funcionario a ser atualizado: ");
                        int indexAtualizar = Integer.parseInt(scanner.nextLine());
                        if (indexAtualizar >= 0 && indexAtualizar < funcionarios.size()) {
                            Funcionario funcionarioAtualizar = funcionarios.get(indexAtualizar);
                            System.out.print("Novo Nome: ");
                            funcionarioAtualizar.setNome(scanner.nextLine());
                            System.out.print("Nova Função: ");
                            funcionarioAtualizar.setFuncao(scanner.nextLine());
                            System.out.println("Funcionario atualizado com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        funcionarioDAO.salvarFuncionarios(funcionarios);
                        break;
                    case 4:
                        System.out.print("Índice do Funcionario a ser deletado: ");
                        int indexDeletar = Integer.parseInt(scanner.nextLine());
                        if (indexDeletar >= 0 && indexDeletar < funcionarios.size()) {
                            funcionarios.remove(indexDeletar);
                            System.out.println("Funcionario deletado com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        funcionarioDAO.salvarFuncionarios(funcionarios);
                        break;
                    case 5:
                        funcionarioDAO.salvarFuncionarios(funcionarios);
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }
    }

    public static void servicoMenu(Scanner scanner, ArrayList<Servico> servico) {
        while (true) {
            ServicoDAO servicoDAO = new ServicoDAO("servico.txt");
            ArrayList<Servico> servicos = servicoDAO.carregarServicos();

            System.out.println("\nMenu Servico:");
            System.out.println("1. Criar Servico");
            System.out.println("2. Ler Servicos");
            System.out.println("3. Atualizar Servico");
            System.out.println("4. Deletar Servico");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Descrição: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Preço: ");
                        double preco = Double.parseDouble(scanner.nextLine());
                        Servico novoServico = new Servico(descricao, preco);
                        servicos.add(novoServico);
                        System.out.println("Servico criado com sucesso!");
                        servicoDAO.salvarServicos(servicos);
                        break;
                    case 2:
                        System.out.println("\nLista de Servicos:");
                        for (int i = 0; i < servicos.size(); i++) {
                            Servico servicoo = servicos.get(i);
                            System.out.println("[" + i + "] Descrição: " + servicoo.getDescricao() + ", Preço: " + servicoo.getPreco());
                        }
                        servicoDAO.salvarServicos(servicos);
                        break;
                    case 3:
                        System.out.print("Índice do Servico a ser atualizado: ");
                        int indexAtualizar = Integer.parseInt(scanner.nextLine());
                        if (indexAtualizar >= 0 && indexAtualizar < servicos.size()) {
                            Servico servicoAtualizar = servicos.get(indexAtualizar);
                            System.out.print("Nova Descrição: ");
                            servicoAtualizar.setDescricao(scanner.nextLine());
                            System.out.print("Novo Preço: ");
                            servicoAtualizar.setPreco(Double.parseDouble(scanner.nextLine()));
                            System.out.println("Servico atualizado com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        servicoDAO.salvarServicos(servicos);
                        break;
                    case 4:
                        System.out.print("Índice do Servico a ser deletado: ");
                        int indexDeletar = Integer.parseInt(scanner.nextLine());
                        if (indexDeletar >= 0 && indexDeletar < servicos.size()) {
                            servicos.remove(indexDeletar);
                            System.out.println("Servico deletado com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        servicoDAO.salvarServicos(servicos);
                        break;
                    case 5:
                        servicoDAO.salvarServicos(servicos);
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }
    }

    public static void agendaMenu(Scanner scanner, ArrayList<Agenda> agendas, ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios, ArrayList<Servico> servicos) {
        while (true) {
            AgendaDAO agendaDAO = new AgendaDAO("agendas.txt");
            ArrayList<Agenda> agenda = agendaDAO.carregarAgendas(clientes, funcionarios, servicos);

            System.out.println("\nMenu Agenda:");
            System.out.println("1. Criar Agenda");
            System.out.println("2. Ler Agendas");
            System.out.println("3. Atualizar Agenda");
            System.out.println("4. Deletar Agenda");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        if (clientes.isEmpty() || funcionarios.isEmpty() || servicos.isEmpty()) {
                            System.out.println("Necessário cadastrar pelo menos um Cliente, um Funcionario e um Servico antes de criar uma Agenda.");
                            break;
                        }
                        System.out.print("Índice do Cliente: ");
                        int clienteIndex = Integer.parseInt(scanner.nextLine());
                        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
                            System.out.println("Índice de Cliente inválido!");
                            break;
                        }

                        System.out.print("Índice do Funcionario: ");
                        int funcionarioIndex = Integer.parseInt(scanner.nextLine());
                        if (funcionarioIndex < 0 || funcionarioIndex >= funcionarios.size()) {
                            System.out.println("Índice de Funcionario inválido!");
                            break;
                        }

                        System.out.print("Índice do Servico: ");
                        int servicoIndex = Integer.parseInt(scanner.nextLine());
                        if (servicoIndex < 0 || servicoIndex >= servicos.size()) {
                            System.out.println("Índice de Servico inválido!");
                            break;
                        }

                        System.out.print("Data (dd/MM/yyyy HH:mm): ");
                        String dataStr = scanner.nextLine();
                        Date data = parseDate(dataStr);
                        if (data == null) {
                            System.out.println("Data inválida! Use o formato dd/MM/yyyy HH:mm.");
                            break;
                        }

                        Agenda novaAgenda = new Agenda(clientes.get(clienteIndex), funcionarios.get(funcionarioIndex), servicos.get(servicoIndex), data);
                        agendas.add(novaAgenda);
                        System.out.println("Agenda criada com sucesso!");
                        agendaDAO.salvarAgendas(agendas);
                        break;
                    case 2:
                        System.out.println("\nLista de Agendas:");
                        for (int i = 0; i < agendas.size(); i++) {
                            Agenda agendaa = agendas.get(i);
                            System.out.println("[" + i + "] Cliente: " + agendaa.getCliente().getNome() + ", Funcionario: " + agendaa.getFuncionario().getNome() + ", Servico: " + agendaa.getServico().getDescricao() + ", Data: " + agendaa.getData());
                        }
                        agendaDAO.salvarAgendas(agendas);
                        break;
                    case 3:
                        System.out.print("Índice da Agenda a ser atualizada: ");
                        int indexAtualizar = Integer.parseInt(scanner.nextLine());
                        if (indexAtualizar >= 0 && indexAtualizar < agendas.size()) {
                            Agenda agendaAtualizar = agendas.get(indexAtualizar);

                            System.out.print("Novo Índice do Cliente: ");
                            clienteIndex = Integer.parseInt(scanner.nextLine());
                            if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
                                System.out.println("Índice de Cliente inválido!");
                                break;
                            }

                            System.out.print("Novo Índice do Funcionario: ");
                            funcionarioIndex = Integer.parseInt(scanner.nextLine());
                            if (funcionarioIndex < 0 || funcionarioIndex >= funcionarios.size()) {
                                System.out.println("Índice de Funcionario inválido!");
                                break;
                            }

                            System.out.print("Novo Índice do Servico: ");
                            servicoIndex = Integer.parseInt(scanner.nextLine());
                            if (servicoIndex < 0 || servicoIndex >= servicos.size()) {
                                System.out.println("Índice de Servico inválido!");
                                break;
                            }

                            System.out.print("Nova Data (dd/MM/yyyy HH:mm): ");
                            dataStr = scanner.nextLine();
                            data = parseDate(dataStr);
                            if (data == null) {
                                System.out.println("Data inválida! Use o formato dd/MM/yyyy HH:mm.");
                                break;
                            }

                            agendaAtualizar.setCliente(clientes.get(clienteIndex));
                            agendaAtualizar.setFuncionario(funcionarios.get(funcionarioIndex));
                            agendaAtualizar.setServico(servicos.get(servicoIndex));
                            agendaAtualizar.setData(data);
                            System.out.println("Agenda atualizada com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        agendaDAO.salvarAgendas(agendas);
                        break;
                    case 4:
                        System.out.print("Índice da Agenda a ser deletada: ");
                        int indexDeletar = Integer.parseInt(scanner.nextLine());
                        if (indexDeletar >= 0 && indexDeletar < agendas.size()) {
                            agendas.remove(indexDeletar);
                            System.out.println("Agenda deletada com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                        agendaDAO.salvarAgendas(agendas);
                        break;
                    case 5:
                        agendaDAO.salvarAgendas(agendas);
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }
    }

    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }
}

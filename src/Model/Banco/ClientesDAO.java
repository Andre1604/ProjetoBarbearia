package Model.Banco;

import Model.Cliente;

import java.io.*;
import java.util.ArrayList;

public class ClientesDAO {
    private String clientesDAO;

    public ClientesDAO(String clientesDAO) {
        this.clientesDAO = clientesDAO;
    }
    public ArrayList<Cliente> carregarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(clientesDAO))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String nome = data[0].trim();
                    String telefone = data[1].trim();
                    Cliente cliente = new Cliente(nome, telefone);
                    clientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar clientes do arquivo: " + e.getMessage());
        }
        return clientes;
    }
    public void salvarClientes(ArrayList<Cliente> clientes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(clientesDAO))) {
            for (Cliente cliente : clientes) {
                writer.write(cliente.getNome() + ", " + cliente.getTelefone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes no arquivo: " + e.getMessage());
        }
    }
}

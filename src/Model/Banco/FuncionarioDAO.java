package Model.Banco;

import Model.Funcionario;
import java.io.*;
import java.util.ArrayList;

public class FuncionarioDAO {
    private String funcionarioDAO;
    public FuncionarioDAO(String funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }
    public ArrayList<Funcionario> carregarFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(funcionarioDAO))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String nome = data[0].trim();
                    String funcao = data[1].trim();
                    Funcionario funcionario = new Funcionario(nome, funcao);
                    funcionarios.add(funcionario);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar funcionários do arquivo: " + e.getMessage());
        }
        return funcionarios;
    }
    public void salvarFuncionarios(ArrayList<Funcionario> funcionarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(funcionarioDAO))) {
            for (Funcionario funcionario : funcionarios) {
                writer.write(funcionario.getNome() + ", " + funcionario.getFuncao());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar funcionários no arquivo: " + e.getMessage());
        }
    }
}
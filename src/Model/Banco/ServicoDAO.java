package Model.Banco;

import Model.Servico;
import java.io.*;
import java.util.ArrayList;

public class ServicoDAO {
    private String servicoDAO;
    public ServicoDAO(String servicoDAO) {
        this.servicoDAO = servicoDAO;
    }
    public ArrayList<Servico> carregarServicos() {
        ArrayList<Servico> servicos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(servicoDAO))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String descricao = data[0].trim();
                    double preco = Double.parseDouble(data[1].trim());
                    Servico servico = new Servico(descricao, preco);
                    servicos.add(servico);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar serviços do arquivo: " + e.getMessage());
        }
        return servicos;
    }
    public void salvarServicos(ArrayList<Servico> servicos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(servicoDAO))) {
            for (Servico servico : servicos) {
                writer.write(servico.getDescricao() + ", " + servico.getPreco());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar serviços no arquivo: " + e.getMessage());
        }
    }
}

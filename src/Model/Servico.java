package Model;

// Servico.java
public class Servico {
    private String descricao;
    private double preco;
    private static int proximoId = 0;
    private int id;
    public Servico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
        this.id = proximoId++;

    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}


package Model;

// Funcionario.java
public class Funcionario extends Pessoa {
    private String funcao;
    private static int proximoId = 0;
    private int id;
    public Funcionario(String nome, String funcao) {
        super(nome);
        this.funcao = funcao;
        this.id = proximoId++;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", funcao='" + funcao + '\'' +
                '}';
    }
}


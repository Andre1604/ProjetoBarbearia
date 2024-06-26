package Model;

public class Cliente extends Pessoa{
    private String telefone;
    private static int proximoId = 0;
    private int id;
    public Cliente(String nome, String telefone) {
        super(nome);
        this.telefone = telefone;
        this.id = proximoId++;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "index=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}


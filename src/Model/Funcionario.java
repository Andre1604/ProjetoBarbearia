package Model;

public class Funcionario extends Pessoa{
    protected String nivelDeAcesso;

    public Funcionario(int id, String nome, String senha, String telefone, String email, String rg, String nivelDeAcesso) {
        super(id, nome, senha, telefone, email, rg);
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public Funcionario(int id, String nome, String nivelDeAcesso) {
        super(id, nome);
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }
}
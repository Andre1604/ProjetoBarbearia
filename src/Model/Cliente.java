package Model;


public class Cliente extends Pessoa{

    protected String endereco;

    public Cliente(int id, String nome, String senha, String telefone, String email, String rg, String endereco) {
        super(id, nome, senha, telefone, email, rg);
        this.endereco = endereco;
    }

    public Cliente(int id, String nome, String endereco) {
        super(id, nome);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
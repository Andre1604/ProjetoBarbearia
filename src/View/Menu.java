package View;

import Controller.CadastroController;
import Model.Banco.Banco;

import java.util.Scanner;

public class Menu {

    private String usuario;

    private String senha;
    public void entrarNoSistema(){
        Banco.inicia();
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== Menu ======");
        System.out.println("Usuario:");
        setUsuario(scanner.nextLine());
        System.out.println("Senha:");
        setSenha(scanner.nextLine());
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void main(String[] args) {
        CadastroController cadastroController = new CadastroController(this);
        entrarNoSistema();
        cadastroController.entrarNoSistema();

    }
}

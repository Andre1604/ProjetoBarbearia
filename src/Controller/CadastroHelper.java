package Controller;

import Model.Cliente;
import View.Menu;

public class CadastroHelper {
    private final Menu view;
    public CadastroHelper(Menu view) {
        this.view = view;
    }

    public Cliente obterModelo(){
        String nome = view.getUsuario();
        String senha = view.getSenha();
        Cliente modelo = new Cliente(0, nome, senha);
        return modelo;
    }

    public void setModelo(Cliente modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();


    }
}

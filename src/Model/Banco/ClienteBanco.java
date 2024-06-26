package Model.Banco;

import Model.Cliente;

import java.util.ArrayList;

public class ClienteBanco {
    public void adicionarCliente(Cliente cliente){
        Banco.cliente.add(cliente);
    }

    public boolean atualizarCliente(Cliente cliente){
        for (int i = 0; i < Banco.cliente.size(); i++) {
            if (idSaoIguais(Banco.cliente.get(i),cliente)){
                Banco.cliente.set(i, cliente);
                return true;
            }
        }
        return false;
    }
    public boolean deletarCliente(Cliente cliente){
        for (Cliente clienteLista : Banco.cliente){
            if(idSaoIguais(clienteLista, cliente)){
                Banco.cliente.remove(clienteLista);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Cliente> selectAll(){
        return Banco.cliente;
    }
    private boolean idSaoIguais(Cliente cliente, Cliente clienteAComparar){
        return cliente.getId() == clienteAComparar.getId();
    }
}

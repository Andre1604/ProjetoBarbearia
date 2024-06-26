package Model.Banco;

import Model.Funcionario;
import java.util.ArrayList;

public class FuncionarioBanco {
    public void adicionarFuncionario(Funcionario funcionario){
        Banco.funcionario.add(funcionario);
    }

    public boolean atualizarFuncionario(Funcionario funcionario){
        for (int i = 0; i < Banco.funcionario.size(); i++) {
            if (idSaoIguais(Banco.funcionario.get(i),funcionario)){
                Banco.funcionario.set(i, funcionario);
                return true;
            }
        }
        return false;
    }
    public boolean deletarFuncionario(Funcionario funcionario){
        for (Funcionario funcionariolista : Banco.funcionario){
            if(idSaoIguais(funcionariolista,funcionario)){
                Banco.funcionario.remove(funcionariolista);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Funcionario> selectAll(){
        return Banco.funcionario;
    }
    private boolean idSaoIguais(Funcionario funcionario, Funcionario funcionarioAComparar){
        return funcionario.getId() == funcionarioAComparar.getId();
    }

    public Funcionario selecionarNomeSenha(FuncionarioBanco funcionarioBanco){

        return null;
    }
}

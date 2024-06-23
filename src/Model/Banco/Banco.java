package Model.Banco;

import Model.Agenda;
import Model.Cliente;
import Model.Servico;
import Model.Funcionario;

import java.util.ArrayList;

public class Banco {

    public static ArrayList<Funcionario> funcionario;
    public static ArrayList<Cliente> cliente;
    public static ArrayList<Servico> servico;
    public static ArrayList<Agenda> agenda;

    public static void inicia(){
        funcionario = new ArrayList<Funcionario>();
        cliente = new ArrayList<Cliente>();
        servico = new ArrayList<Servico>();
        agenda = new ArrayList<Agenda>();


    }

}

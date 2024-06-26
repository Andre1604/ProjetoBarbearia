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

        Funcionario funcionario1 = new Funcionario(1, "André", "123", "987104644", "andre@gmail.com", "12332145978", "Total");
        Funcionario funcionario2 = new Funcionario(2, "Marcos", "321", "912345678", "marcos@gmail.com", "98765445698", "Total");

        Cliente cliente1 = new Cliente(3, "Cliente1", "456", "984561274", "cliente1@gmail.com", "11245478965", "Cliente");
        Cliente cliente2 = new Cliente(4, "Cliente2", "789", "789451236", "cliente2@gmail.com", "21564886321", "Cliente");

        Servico servico1 = new Servico(5, "Corte de cabelo", 35);
        Servico servico2 = new Servico(6, "Barba", 20);
        Servico servico3 = new Servico(5, "Corte de cabelo e Barba", 50);
        Servico servico4 = new Servico(7, "Sombrancelha", 15);
        Servico servico5 = new Servico(8, "Cabelo, Barba e Sombrancelha", 60);

        Agenda agenda1 = new Agenda(1, cliente1, servico1, "07/07/2024 16:30");
        Agenda agenda2 = new Agenda(1, cliente1, servico1, "08/07/2024 15:00");
    }
}

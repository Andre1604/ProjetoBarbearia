package View;

// AgendaView.java
import java.util.Date;

public class AgendaView {
        public void exibirDetalhesAgenda(String cliente, String funcionario, String servico, Date data) {
                System.out.println("Agenda: ");
                System.out.println("Cliente: " + cliente);
                System.out.println("Funcionario: " + funcionario);
                System.out.println("Serviço: " + servico);
                System.out.println("Data: " + data);
        }
}


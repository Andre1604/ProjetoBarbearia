package Controller;

import View.Agendamento;
import View.Menu;

public class MenuController {

    private final Menu view;

    public MenuController(Menu view) {
        this.view = view;
    }

    public void entrarAgenda(){
        Agendamento agendamento = new Agendamento();
        System.out.println("====== Agenda ======");
        System.out.println("1 - Exibir agenda\n2 - Remover Agendamento\n3 - Adicionar Agendamento");
    }
}

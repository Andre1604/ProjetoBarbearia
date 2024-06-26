package Model.Banco;

import Model.Agenda;
import java.util.ArrayList;

public class AgendaBanco {
    public void adicionarAgenda(Agenda agenda){
        Banco.agenda.add(agenda);
    }

    public boolean atualizarAgenda(Agenda agenda){
        for (int i = 0; i < Banco.agenda.size(); i++) {
            if (idSaoIguais(Banco.agenda.get(i),agenda)){
                Banco.agenda.set(i, agenda);
                return true;
            }
        }
        return false;
    }
    public boolean deletarAgenda(Agenda agenda){
        for (Agenda agendaLista : Banco.agenda){
            if(idSaoIguais(agendaLista, agenda)){
                Banco.agenda.remove(agendaLista);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Agenda> selectAll(){
        return Banco.agenda;
    }
    private boolean idSaoIguais(Agenda agenda, Agenda agendaAComparar){
        return agenda.getId() == agendaAComparar.getId();
    }
    public void exibirAgenda(){
        for (int i = 0; i < Banco.agenda.size(); i++) {
            System.out.println(Banco.agenda);
        }
    }

}

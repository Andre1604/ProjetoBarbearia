package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agenda {
    private int id;
    private Cliente cliente;
    private Servico servico;
    private Date data;

    public Agenda(int id, Cliente cliente, Servico servico, String data) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        try {
            this.data = new SimpleDateFormat("dd/mm/aaaa hh:mm").parse(data);
        }
        catch (ParseException ex){
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

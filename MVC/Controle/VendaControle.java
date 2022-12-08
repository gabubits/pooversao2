package Trabalho.MVC.Controle;

import Trabalho.MVC.Modelo.Cliente;
import Trabalho.MVC.Modelo.Ingresso;
import Trabalho.MVC.Persistencia.VendaP;

public class VendaControle extends Controle {

    private IngressoControle dIngressoControle;
    private ClienteControle dClienteControle;

    public VendaControle(IngressoControle pIngressoControle, ClienteControle pClienteControle){
        super(VendaP.getinstancia());
        this.dIngressoControle = pIngressoControle;
        this.dClienteControle = pClienteControle;
    }

    public Ingresso BuscarIDIngresso(int id) { return (Ingresso) dIngressoControle.BuscarID(id); }
    public Ingresso BuscarStringIngresso(String string) { return (Ingresso) dIngressoControle.BuscarString(string); }

    public Cliente BuscarIDCliente(int id) { return (Cliente) dClienteControle.BuscarID(id); }
    public Cliente BuscarStringCliente(String string) { return (Cliente) dClienteControle.BuscarString(string); }
}

package Trabalho.MVC.Modelo;

import java.util.LinkedList;

public class Venda extends Entidade {

    private LinkedList<Ingresso> IngressosComprados = new LinkedList<>();
    private Cliente ClienteDaVenda;

    public Venda(){
        super();
        ClienteDaVenda = null;
    }

    public Venda(Cliente clientedavenda, Ingresso novoingresso){
        this.ClienteDaVenda = clientedavenda;
        this.IngressosComprados.add(novoingresso);
    }

    public LinkedList<Ingresso> getIngressosComprados(){ return IngressosComprados; }
    public Cliente getClienteDaVenda(){ return ClienteDaVenda; }

    public String toString(){
        return String.format("Venda ID " + getId() + ":" + "\n\t Ingressos comprados: " +
                getIngressosComprados() + "\n\t Cliente: " + getClienteDaVenda().getNome() + "; CPF: " +
                getClienteDaVenda().getCpf());
    }

}
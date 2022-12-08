package Trabalho.MVC.Controle;

import Trabalho.MVC.Modelo.Entidade;
import Trabalho.MVC.Persistencia.Persistencia;

public abstract class Controle {
    
    Persistencia persistencia = null;

    public Controle(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public void Inserir(Entidade entidade) { persistencia.Inserir(entidade); }

    public void Excluir(Entidade entidade) { persistencia.Excluir(entidade); }

    public Entidade BuscarID(int id){ return persistencia.BuscarId(id); }

    public Entidade BuscarString(String string){ return persistencia.BuscarString(string); }

    public void CarregarArquivo(){ persistencia.CarregarArquivo(); }

    public void AtualizarArquivo(){ persistencia.AtualizarArquivo(); }

}

package Trabalho.MVC.Controle;

import Trabalho.MVC.Modelo.Filme;
import Trabalho.MVC.Persistencia.IngressoP;

public class IngressoControle extends Controle{

    private FilmeControle dFilmeControle;

    public IngressoControle(FilmeControle pFilmeControle) {
        super(IngressoP.getinstancia());
        this.dFilmeControle = pFilmeControle;
    }

    public Filme BuscarIDFilme(int id) { return (Filme) dFilmeControle.BuscarID(id); }
    public Filme BuscarStringFilme(String string) { return (Filme) dFilmeControle.BuscarString(string); }
}

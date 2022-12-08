package Trabalho.MVC.Controle;

import Trabalho.MVC.Persistencia.FilmeP;

public class FilmeControle extends Controle{

    public FilmeControle() { super(FilmeP.getinstancia()); }
}
